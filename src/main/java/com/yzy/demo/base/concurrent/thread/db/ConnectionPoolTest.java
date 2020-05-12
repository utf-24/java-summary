package com.yzy.demo.base.concurrent.thread.db;

import com.yzy.demo.base.concurrent.thread.util.ThreadUtils;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 测试数据库连接
 *
 * @author young
 * @date 2019/9/24 11:10
 */
public class ConnectionPoolTest {

    private static ConnectionPool pool = new ConnectionPool(10);
    /**
     * 保证所有runner线程能同时开始
     */
    private static CountDownLatch start = new CountDownLatch(1);
    private static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        /**
         * 原子类做参数可以共享一份地址？
         */
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;

        // 显式创建线程
//        for (int i = 0; i < threadCount; i++) {
//            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "connectionRunnerThread");
//            thread.start();
//        }

        ExecutorService pool = ThreadUtils.createThreadPool(50 ,"ctRunnerThread");
        IntStream.range(0,threadCount).forEach(i-> pool.execute(new ConnectionRunner(count,got,notGot)));
        start.countDown();
        end.await();
        System.out.println("total invoke: " + threadCount * count);
        System.out.println("get connection: " + got);
        System.out.println("not got connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }


        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                Connection connection = null;
                try {
                    connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();

                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {

                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
