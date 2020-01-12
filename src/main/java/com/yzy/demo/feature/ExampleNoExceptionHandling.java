package com.yzy.demo.feature;

import java.util.concurrent.CompletableFuture;

/**
 * @author young
 * @date 2019/8/1 11:11
 */
public class ExampleNoExceptionHandling {
    public static void main(String[] args) throws Exception {
        System.out.println("-- running CompletableFuture --");
        CompletableFuture<Void> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("running task");
                    return 1 / 0;
                })
                .thenApply(input -> {
                    System.out.println("multiplying by 2");
                    return input * 2;
                })
                .thenAccept(System.out::println);

        Thread.sleep(3000);//let the stages complete
        System.out.println("-- checking exceptions --");
        boolean b = completableFuture.isCompletedExceptionally();
        System.out.println("completedExceptionally: " + b);
        System.out.println("-- calling join --");
        completableFuture.join();
    }
}