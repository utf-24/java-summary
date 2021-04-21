package com.yzy.demo.jvm.jmm;

/**
 * volatile变量自增运算
 * race++ 字节码
 * getstatic
 * iconst_1
 * iadd
 * putstatic
 * 不准的原因：race++ 分为四个字节码指令，只有getstatic指令能保证值是对的，
 * 后续三个指令操作时race的值已经被其他线程覆盖了
 * @author yangzyh
 * @date 2021/4/21 19:21
 */
public class VolatileTest {
    private static volatile int race =0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i <THREADS_COUNT ; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 20000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }
    while (Thread.activeCount() > 2) {
        Thread.yield();
    }
        // expect: 200000, result: always lt 200000
        System.out.println(race);
    }
}
