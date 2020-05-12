package com.yzy.demo.base.concurrent.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author young
 * @date 2019/8/7 15:24
 */
public class CyclicBarrierTest2 {
    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println(3);
        }
    }

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        cyclicBarrier.await();
        System.out.println(2);
    }
}
