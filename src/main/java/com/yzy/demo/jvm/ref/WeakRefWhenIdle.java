package com.yzy.demo.jvm.ref;

import java.lang.ref.WeakReference;

/**
 * 测试弱引用在内存冲突情况下是否会持有对象进行回收
 *
 * @author young
 * @date 2020/1/25 23:16
 */
public class WeakRefWhenIdle {
    public static void main(String[] args) {
        House seller = new House();
        WeakReference<House> buyer = new WeakReference<>(seller);
        seller = null;
        long start = System.nanoTime();
        int count = 0;
        while (true) {
            if (buyer.get() == null) {
                long duration = (System.nanoTime() - start) / (1000 * 1000);
                System.out.println("house is null and exited time: " + duration);
                break;
            } else {
                System.out.println("still there, count= " + (count++));
            }
        }
    }

    static class House {
        private final Integer DOOR_NUM = 2000;
        public Door[] doors = new Door[DOOR_NUM];
    }

    class Door {
    }
}
