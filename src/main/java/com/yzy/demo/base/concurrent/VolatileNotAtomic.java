package com.yzy.demo.base.concurrent;

/**
 * volatile非原子性验证(需要加锁保证结果)
 * @author young
 * @date 2020/1/19 22:14
 */
public class VolatileNotAtomic {

    public static volatile int COUNT = 0;

    public static final int NUM = 10000;

    public static void main(String[] args) {
        SubtractThread subtractThread = new SubtractThread();
        subtractThread.start();
        for(int i = 0; i<NUM; i++) {
            synchronized (VolatileNotAtomic.class) {
                COUNT++;
            }
        }
        // 等待减法线程结束
        while (subtractThread.isAlive()){}

        System.out.println("count: "+COUNT);
    }

    private static class SubtractThread extends Thread {

        @Override
        public void run() {
            for(int i = 0; i< NUM; i++) {
                synchronized (VolatileNotAtomic.class) {
                    COUNT--;
                }
            }
        }
    }
}
