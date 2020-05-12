package com.yzy.demo.base.concurrent.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 原子类实例
 *
 * @author young
 * @date 2019/8/19 19:40
 */
public class Counter {
    private int i =0;
    private AtomicInteger atomicI = new AtomicInteger(0);

    private void count(){
        i++;
    }

    private void safeCount(){
        for(;;){
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i,++i);
            if(suc){
                break;
            }
        }
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();
        List<Thread> cas = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for(int i = 0; i<100; i++){
            Thread thread = new Thread(() -> {
                for(int i1 = 0; i1 <10000; i1++){
                    counter.count();
                    counter.safeCount();
                }
            });
            cas.add(thread);
        }
        for(Thread t: cas){
            t.start();
        }

        for(Thread t: cas){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("i= "+counter.i);
        System.out.println("atmoicI = "+counter.atomicI);
        System.out.println(System.currentTimeMillis() - start);
    }
}
