package com.yzy.demo.base.concurrent.thread.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程工厂
 *
 * @author young
 * @date 2020/1/25 16:06
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    /**
     * 定义线程组名称
     *
     * @param whatFeatureOfGroup
     */
    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's " +whatFeatureOfGroup + "-worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.incrementAndGet();
        Thread thread = new Thread(null,task,name,0);
        System.out.println("thread name: "+name);

        return thread;
    }


}
