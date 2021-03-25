package com.yzy.demo.concurrent.thread;

/**
 * 测试synchronized 类型
 * @author yangzyh
 * @date 2021/3/25 12:53
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {

        }
        m();
    }

    private static synchronized void m() {
    }
}
