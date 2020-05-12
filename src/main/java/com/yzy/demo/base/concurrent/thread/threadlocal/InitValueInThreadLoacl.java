package com.yzy.demo.base.concurrent.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 没明白什么意思。。
 * 参考《码出高效》p.257
 *
 * @author young
 * @date 2020/1/26 14:45
 */
public class InitValueInThreadLoacl {
    private static final StringBuilder INIT_VALUE =
            new StringBuilder("init");
    private static final ThreadLocal<StringBuilder> builder =
            ThreadLocal.withInitial(()->INIT_VALUE);

    private static class AppendStringThread extends Thread {
        @Override
        public void run() {
            StringBuilder inThread = builder.get();
            for(int i = 0 ;i< 10; i++) {
                inThread.append(" " +i);
            }
            System.out.println(inThread.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0 ;i<10; i++) {
            new AppendStringThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }
}
