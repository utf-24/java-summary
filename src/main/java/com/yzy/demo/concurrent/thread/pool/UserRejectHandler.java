package com.yzy.demo.concurrent.thread.pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池策略拒绝类
 *
 * @author young
 * @date 2020/1/25 16:24
 */
public class UserRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        System.out.println("task reject." + executor.toString());
    }
}
