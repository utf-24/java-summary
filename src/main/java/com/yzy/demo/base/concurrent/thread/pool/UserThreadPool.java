package com.yzy.demo.base.concurrent.thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义线程池
 * 参考码出高效java开发手册
 * @author young
 * @date 2020/1/25 16:28
 */
public class UserThreadPool {

    /**
     * 任务执行体
     */
    static class Task implements Runnable{
        private final AtomicLong count = new AtomicLong(0L);

        @Override
        public void run() {
            System.out.println("running_ "+count.incrementAndGet());
        }
    }

    public static void main(String[] args) {
        // 缓存队列
        BlockingQueue queue = new LinkedBlockingQueue(2);
        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");

        UserRejectHandler handler = new UserRejectHandler();
        // 创建连个线程池
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1,2,
                60, TimeUnit.SECONDS, queue, f1,handler);

        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1,2,
                60, TimeUnit.SECONDS, queue, f2,handler);

        // 创建400个任务线程
        Runnable task = new Task();
        for(int i =0; i<200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }

        threadPoolFirst.shutdown();
        threadPoolSecond.shutdown();
    }
}
