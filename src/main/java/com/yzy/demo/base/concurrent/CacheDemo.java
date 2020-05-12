package com.yzy.demo.base.concurrent;

import java.util.concurrent.*;

/**
 * @author young
 * @date 2020/2/24 21:57
 */
public class CacheDemo {

    public static final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        new Thread(()-> cache.put("result",Thread.currentThread().getName())).start();
        new Thread(()-> cache.put("result",Thread.currentThread().getName())).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cache is: " + cache.get("result"));
    }
}
