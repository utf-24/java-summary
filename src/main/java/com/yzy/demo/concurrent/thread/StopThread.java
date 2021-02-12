package com.yzy.demo.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * stopFlag没有被同步，会导致活性失败，程序一直死循环
 * effective java 78
 * @author yangzyh
 * @date 2021/2/12 11:56
 */
public class StopThread {
    private static boolean stopFlag;

    public static void main(String[] args) throws InterruptedException {
        Thread backGroundThread = new Thread(()->{
            int i = 0;
            while (!stopFlag) {
                i++;
            }
            System.out.println(i);
        });
        backGroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopFlag = true;
    }
}
