package com.yzy.demo.concurrent.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * demonstrates the Callable interface and executors.
 * @author yangzyh
 * @date 2020/8/14 10:15
 */
@Slf4j
public class ExecutorDemo {
    /**
     * Counts occurrences of a given word in a file.
     * @param word
     * @param path
     * @return the number of times the word occurs int the given file
     */
    public static long occurrences(String word, Path path) {
        try (var in = new Scanner(path)) {
            int count = 0;
            while (in.hasNext()) {
                if(in.next().equals(word)) count++;
            }
            return count;
        } catch (IOException e) {
            log.warn("count error...,word:{},path,{}",word, path);
            return 0;
        }
    }

    /**
     * returns all descendants of a given directory
     * @param rootDir
     * @return
     * @throws IOException
     */
    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)){
            return entries.filter(Files::isRegularFile)
                    .collect(Collectors.toSet());
        }
    }

    /**
     * Yields a task that searches for a word in a file.
     * @param word  the word to search
     * @param path  the file in which to search
     * @return the search task that yields the path upon success
     */
    public static Callable<Path> searchForTask(String word, Path path) {
        return ()->{
            try(var in = new Scanner(path)){
                while (in.hasNext()) {
                    if(in.next().equals(word)) return path;
                    if(Thread.currentThread().isInterrupted()) {
                        log.warn("Search in " + path + "canceled.");
                        return null;
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        try (var in = new Scanner(System.in)){
            log.info("enter base directory:");
            String start = in.nextLine();
            log.info("enter keyword(e.g. volatile)");
            String word = in.nextLine();

            Set<Path> files = descendants(Path.of(start));
            log.info("file num: {}", files.size());
            var tasks = new ArrayList<Callable<Long>>();
            for(Path file: files) {
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }
            ExecutorService executor = Executors.newCachedThreadPool();
            // use a single thread executor instead to see if multiple threads speed up the search
            // 确实多线程快些
            //ExecutorService executor = Executors.newSingleThreadExecutor();

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;
            for(Future<Long> result: results) {
                total += result.get();
            }
            Instant endTime = Instant.now();
            log.info("Occurrences of " +word + ": " + total);
            log.info("time elapsed: " + Duration.between(startTime, endTime).toMillis() + "ms") ;

            var searchTasks = new ArrayList<Callable<Path>>();
            for(Path file: files){
                searchTasks.add(searchForTask(word,file));
            }
            Path found = executor.invokeAny(searchTasks);
            log.info(word + " occurs in: {}", found);
            if(executor instanceof ThreadPoolExecutor) {
                log.info("Largest pool size: {}", ((ThreadPoolExecutor) executor).getLargestPoolSize());
            }
            executor.shutdown();
        }
    }
}
