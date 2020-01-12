package com.yzy.demo.feature;

import java.sql.SQLOutput;
import java.time.Clock;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author young
 * @date 2019/7/29 9:14
 */
public class CompletableFutureDemo {
    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();
    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
        int random = rand.nextInt(1000);

        return random;
    }
    public static void main(String[] args) throws Exception {
        ImInfo imInfo = new ImInfo();
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                CompletableFutureDemo::getMoreData).thenAccept(imInfo::setResult);
        System.out.println("parallel..");
//        future.join();
        System.out.println(imInfo.getResult());
    }
}
