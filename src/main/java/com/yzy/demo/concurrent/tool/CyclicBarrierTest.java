package com.yzy.demo.concurrent.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 结果分析：
 * main 3
 * Thread-0 1
 * main 2
 * 主线程先到达了barrier，因为其他线程还没到barrier，所以触发了barrierAction，输出main 3，
 * thread-0 随后调用await方法，barrier打开，所有线程终止阻塞状态，分别执行后续操作：thread-0
 * 线程输出 thread-0 1 ， main线程输出 main 2
 *
 * @author young
 * @date 2019/9/27 16:53
 */
public class CyclicBarrierTest {
    static CyclicBarrier barrier = new CyclicBarrier(2, new A());
    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 3");
        }
    }
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(()->{
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " 1");
        }).start();
            barrier.await();
        System.out.println(Thread.currentThread().getName() + " 2");
    }
}
