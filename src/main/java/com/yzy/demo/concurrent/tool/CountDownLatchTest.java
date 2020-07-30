package com.yzy.demo.concurrent.tool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * countDownLatch异常测试
 * @author young
 * @date 2020/1/20 21:27Q
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        Thread thread1 = new TranslateThread("1st content", count);
        Thread thread2 = new TranslateThread("2nd content", count);
        Thread thread3 = new TranslateThread("3rd content", count);

        //捕获子线程的异常
        thread1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t + "throws exception: " + e);
            count.countDown();
        });
        thread2.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t + "throws exception: " + e);
            count.countDown();
        });
        thread3.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t + "throws exception: " + e);
            count.countDown();
        });

        thread1.start();
        thread2.start();
        thread3.start();

        count.await(30, TimeUnit.SECONDS);
        System.out.println("all thread finish");
    }

    static class TranslateThread extends Thread{
        private String content;
        private final CountDownLatch count;

        public TranslateThread(String content, CountDownLatch count) {
            this.content = content;
            this.count = count;
        }

        @Override
        public void run() {
            // 模拟翻译失败抛异常的情况
            if( Math.random() > 0.5) {
                throw new RuntimeException("illegal character");
            }
            System.out.println(content + "has translated..");
            count.countDown();
        }
    }

}
