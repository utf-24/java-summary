package com.yzy.demo.jvm.ref;

import java.lang.ref.SoftReference;

/**
 * 测试内存没有OOM时,软引用持有的引用是否会被回收
 *
 * @author young
 * @date 2020/1/25 23:04
 */
public class SoftRefWhenIdle {

    public static void main(String[] args) {
        House seller = new House();
        SoftReference<House> buyer = new SoftReference<House>(seller);
        seller =null;
        while (true) {
            System.gc();
            System.runFinalization();

            if(buyer.get() == null){
                System.out.println("house is null");
                break;
            }else {
                System.out.println("still there");
            }
        }
    }

    static class House{
        private final Integer DOOR_NUM = 2000;
        public Door[] doors = new Door[DOOR_NUM];
    }

    class Door{}
}
