package com.yzy.demo.jvm.classLoad;

/**
 * @author young
 * @date 2019/6/9 10:13
 */
public class SuperClass {
    static {
        System.out.println("super class init");
    }
    public static int value = 123;
}
