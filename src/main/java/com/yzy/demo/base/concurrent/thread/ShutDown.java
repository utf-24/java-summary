package com.yzy.demo.base.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author young
 * @date 2019/5/22 15:56
 */
public class ShutDown {
    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread1");
        countThread.start();
// 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread2");
        countThread.start();
// 睡眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }
    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
                String name = Thread.currentThread().getName();
                System.out.println(name);
            }
            System.out.println("Count i = " + i + Thread.currentThread().getName());
        }
        public void cancel() {
            on = false;
        }
    }
}