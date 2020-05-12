package com.yzy.demo.base.concurrent.thread;

import com.yzy.demo.base.concurrent.thread.util.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * @author young
 * @date 2019/8/8 8:38
 */
public class SemaphoreTest {
    private static int THREAD_COUNT = 30;
    static ExecutorService pool = ThreadUtils
            .createThreadPool(30,"semaphoreTest");
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        IntStream.range(0,THREAD_COUNT).forEach(i-> pool.execute(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" save data");
                System.out.println("availablePermits: "+ semaphore.availablePermits());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        pool.shutdown();
    }
}
