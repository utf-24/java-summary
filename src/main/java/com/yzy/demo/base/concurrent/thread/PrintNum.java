package com.yzy.demo.base.concurrent.thread;

/**
 * 两个线程交替打印出1到一万
 * @author young
 * @date 2019/9/23 19:51
 */
public class PrintNum {
    private static  int num = 1;
    private static final Object LOCK = new Object();
    private static final int END = 10000;
    public static void main(String[] args) {
        Thread oddThread = new Thread(new PrintThread(),"odd");
        Thread evenThread = new Thread(new PrintThread (),"even");
        oddThread.start();
        evenThread.start();
        // 使用线程池的方式
//        ExecutorService printNumPools = ThreadUtils.createThreadPool(2,"printNum");
//        printNumPools.execute(PrintNum::printNum);
//        printNumPools.execute(PrintNum::printNum);

    }

    static class PrintThread implements Runnable{
        @Override
        public void run() {
            printNum();
        }
    }

    private static void printNum() {
        {
            while(num <=END) {
                synchronized (LOCK){
                    LOCK.notifyAll();
                    System.out.println(Thread.currentThread().getName() +": "+num++);
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
