package com.yzy.demo.jvm.classload;

/**
 * @author young
 * @date 2019/6/9 14:24
 */
public class StaticTest {
    static class DeadLoopClass {
        static {
            if (true) {
                System.out.println(Thread.currentThread() + " init DeadLoopClass");
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " end");
            }
        };
        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }
}
