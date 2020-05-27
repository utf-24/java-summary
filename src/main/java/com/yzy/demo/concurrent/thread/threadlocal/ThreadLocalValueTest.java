package com.yzy.demo.concurrent.thread.threadlocal;

/**
 *  子线程无法获取父线程设置的ThreadLocal值
 * @author young
 * @date 2019/9/24 16:25
 */
public class ThreadLocalValueTest {
    private static ThreadLocal<String> VALUE = new ThreadLocal<>();
//    private static ThreadLocal<String> VALUE = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        VALUE.set("parent value");
        Thread child = new Thread(()-> System.out.println("value: "+VALUE.get()));
        child.start();
    }
}
