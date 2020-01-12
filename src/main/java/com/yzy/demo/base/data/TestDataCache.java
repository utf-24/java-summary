package com.yzy.demo.base.data;

/**
 * @author young
 * @date 2019/10/24 22:05
 */
public class TestDataCache {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(1001);
        Integer b = Integer.valueOf(1001);
        System.out.println("integer = 10, cache is " + (a==b));
    }
}
