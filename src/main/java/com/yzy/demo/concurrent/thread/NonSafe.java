package com.yzy.demo.concurrent.thread;

/**
 * 非线程安全实例
 *
 * @author young
 * @date 2019/9/24 21:18
 */
public class NonSafe {
    private int a = 0;

    public int getA(){
        return a++;
    }

    public static void main(String[] args) {
        NonSafe nonSafe = new NonSafe();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 10000; i++){
                    nonSafe.getA();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 10000; i++){
                    nonSafe.getA();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nonSafe.getA());
    }
}
