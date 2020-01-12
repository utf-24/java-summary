package com.yzy.demo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author young
 * @date 2019/9/27 16:53
 */
public class CyclicBarrierTest {
    static CyclicBarrier barrier = new CyclicBarrier(2, new A());
    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "3");
        }
    }
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(()->{
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "1");
        }).start();
            barrier.await();
        System.out.println(Thread.currentThread().getName() + "2");
    }
}
