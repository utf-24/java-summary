package com.yzy.demo.base.concurrent.jcip.chapter3;

/**
 * p27 3-1
 * 会输出0 或者一直不输出？ 并没有。。
 *
 * @author yangzyh
 * @date 2020/5/23 9:00
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
