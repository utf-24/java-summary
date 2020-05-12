package com.yzy.demo.base.concurrent.thread;

import java.util.stream.LongStream;

/**
 * @author young
 * @date 2019/8/10 10:30
 */
public class ThreadCastTest {
    /**
     * 变量因素，决定并发和串行的效率
     */
    public static final long COUNT =100000000;

    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        int b = 0;
        Thread thread = new Thread(()
                -> LongStream.range(0,COUNT).forEach((long i)
                -> i++));
        thread.start();
        thread.join();
        LongStream.range(0,COUNT).forEach(j->{
            j--;
        });
        thread.join();
        long now = System.currentTimeMillis();
        System.out.println("currency cost: "+(now-start));
    }

    public static void serial(){
        long start = System.currentTimeMillis();
        LongStream.range(0,COUNT).forEach(k->{
            k++;
        });
        LongStream.range(0,COUNT).forEach(m->{
        m--;
        });
        long now = System.currentTimeMillis();
        System.out.println("serial cost: "+(now-start));
    }

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

}
