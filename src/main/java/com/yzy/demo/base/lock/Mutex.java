package com.yzy.demo.base.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author young
 * @date 2019/5/25 9:41
 */
class Mutex implements Lock {

    /**
     * 静态内部类，自定义同步器
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 是否处于占用状态
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 状态为0的时候获取锁
         */
        @Override
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放锁，将状态置为0
         */
        @Override
        public boolean tryRelease(int releases) {
            if (Thread.currentThread() != getExclusiveOwnerThread() || getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            boolean free = false;
            if (compareAndSetState(1, 0)) {
                setExclusiveOwnerThread(null);
                free = true;
            }

            return free;
        }

        /**
         * 返回一个condition,每个condition都包含了一个condition队列
         */
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    /**
     * 将操作代理到同步器sync上
     */
    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        new Thread(() -> {
            mutex.lock();
            System.out.println(Thread.currentThread() + " get lock");
            mutex.unlock();
            System.out.println(Thread.currentThread() + " unlcok");
        },"t1").start();

        new Thread(() -> {
            mutex.lock();
            System.out.println(Thread.currentThread() + " get lock");
            mutex.unlock();
            System.out.println(Thread.currentThread() + " unlcok");
        },"t2").start();

        mutex.lock();
        System.out.println(Thread.currentThread() + " get lock");
        mutex.unlock();
        System.out.println(Thread.currentThread() + " unlock");
    }
}
