package com.yzy.demo.jvm.gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xms20m
 * @author yangzyh
 * @date 2022/1/26 13:54
 */
public class SoftReferenceHouse {
    public static void main(String[] args) {
        //List<SoftReference> houses = new ArrayList<>();
        List<House> houses = new ArrayList<>();

        int i = 0;
        while (true) {
            houses.add(new House());
            //SoftReference<House> buyer2 = new SoftReference<>(new House());
            //houses.add(buyer2);
            System.out.println("i= " + (++i));
        }
    }
}

class House{
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];
    class Door{}
}
