package com.yzy.demo.concurrent.thread.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author young
 * @date 2019/8/7 16:31
 */
public class ThreadUtils {

    public static ExecutorService createThreadPool(int threadNum, String threadName) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadName + "-pool-%d").build();

        //Common Thread Pool

        return new ThreadPoolExecutor(threadNum, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
    }
}
