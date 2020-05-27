package com.yzy.demo.concurrent.tool;

import com.yzy.demo.concurrent.thread.util.ThreadUtils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;

/**
 * @author young
 * @date 2019/8/8 8:54
 */
public class ExchangerTest {
    static ExecutorService pool = ThreadUtils
            .createThreadPool(2,"exchangerTest");
    private static final Exchanger<String> EXGR = new Exchanger<>();
    public static void main(String[] args) {
        pool.execute(()->{
            String a = "bank count A";
            try {
                String data = EXGR.exchange(a);
                System.out.println(Thread.currentThread().getName()+" get data: " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(()->{
            String b = "bank count B";
            try {
                String a = EXGR.exchange(b);
                System.out.println(Thread.currentThread().getName()
                        + " a is equal b ? "+a.equals(b));
                System.out.println("a: "+a);
                System.out.println("b: "+b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
