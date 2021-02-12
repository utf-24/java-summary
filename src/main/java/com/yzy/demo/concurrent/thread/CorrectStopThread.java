package com.yzy.demo.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * 正确的终止线程，访问stopFlag变量时加锁
 * effective java 78
 * @author yangzyh
 * @date 2021/2/12 12:05
 */
public class CorrectStopThread {
    private static boolean stopFlag;

    private static synchronized boolean getStopFlag(){
        return stopFlag;
    }

    private static synchronized void setStopFlag(boolean val) {
        stopFlag = val;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backGroundThread = new Thread(()->{
            int i = 0;
            while (!getStopFlag()) {
                i++;
            }
            System.out.println(i);
        });
        backGroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        setStopFlag(true);
    }
}
