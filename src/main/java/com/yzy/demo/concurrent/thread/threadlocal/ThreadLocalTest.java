package com.yzy.demo.concurrent.thread.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @author young
 * @date 2019/9/24 15:25
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    private static ThreadLocal<String> THREAD_LOCAL_2 = new ThreadLocal<>();

    private static CountDownLatch start = new CountDownLatch(1);

    private static void print(String thread) {
        //打印线程的本地变量
        System.out.println(thread+" " + THREAD_LOCAL.get());
        //删除线程的本地变量
//        THREAD_LOCAL.remove();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            THREAD_LOCAL_2.set("t1 aaa");
            THREAD_LOCAL.set("t1 var");
            print("t1");
            System.out.println("after remove t1：" + THREAD_LOCAL.get());
        });
        Thread t2 = new Thread(()->{
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            THREAD_LOCAL.set("t2 var");
           print("t2");
            System.out.println("after remove t2: " + THREAD_LOCAL.get());
        });
        t1.start();
        t2.start();
        System.out.println("see what happens..");
        start.countDown();
    }
}
