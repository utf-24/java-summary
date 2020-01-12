/**
 * 
 */
package com.yzy.demo.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import com.yzy.demo.util.SleepUtils;

/**
 * 测试自定义的锁
 * @author Young
 */
public class TwinsLockTest {

    static CountDownLatch start = new CountDownLatch(1);

    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                try {
                    start.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动十个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        start.countDown();

        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwinsLockTest twinsLockTest = new TwinsLockTest();
        twinsLockTest.test();
    }
}
