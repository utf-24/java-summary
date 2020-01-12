package com.yzy.demo.feature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author young
 * @date 2019/8/2 9:10
 */
public class AsyncService {
    public int getResult(){
        System.out.println("execute asyncService");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
                CompletableFutureDemo::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        int result;
        try {
            result = f.get();
        } catch (Exception e) {
            System.out.println("error occur");
            e.printStackTrace();
            return -99;
        }
        System.out.println("finish asyncService");
        return result;
    }
}
