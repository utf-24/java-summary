package com.yzy.demo.jvm.classLoad;

/**
 * @author young
 * @date 2019/6/9 10:22
 */
public class ConstClass {
    static {
        System.out.println("constClass init");
    }
    public static final String HELLO_WORLD = "hello world";

    public static void main(String[] args) {
        System.out.println(HELLO_WORLD);
    }
}
