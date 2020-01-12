package com.yzy.demo.concurrent.thread;

import com.yzy.demo.util.SleepUtils;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author young
 * @date 2019/8/7 9:05
 */
public class CountdownLatchDemo {

    static class Service {

        private CountDownLatch latch;

        public Service(CountDownLatch latch) {
            this.latch = latch;
        }

        public void exec() {
            try {
                System.out.println(Thread.currentThread().getName() + " execute task. ");
                SleepUtils.second(1);
                System.out.println(Thread.currentThread().getName() + " finished task. ");
            } finally {
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Service service = new Service(latch);
        Runnable task = service::exec;
        IntStream.range(0,5).forEach(i->{
            Thread thread = new Thread(task);
            thread.start();
        });
        System.out.println("main thread wait");
        latch.await();
        System.out.println("main thread finish wait");
    }
}
