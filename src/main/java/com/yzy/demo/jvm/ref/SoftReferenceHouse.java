package com.yzy.demo.jvm.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试软引用
 *
 * @author young
 * @date 2020/1/25 22:34
 */
public class SoftReferenceHouse {
    public static void main(String[] args) {
//        List<House> houses = new ArrayList<>();
        List<SoftReference> houses = new ArrayList<SoftReference>();

        int i =0;
        while (true) {
//            houses.add(new House());
            SoftReference<House> buyer =
                    new SoftReference<House>(new House());
            houses.add(buyer);
            System.out.println("i= "+ (++i));
        }
    }

    static class House{
        private final Integer DOOR_NUM = 2000;
        public Door[] doors = new Door[DOOR_NUM];
    }

    class Door{}
}
