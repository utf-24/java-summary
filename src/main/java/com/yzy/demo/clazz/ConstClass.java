package com.yzy.demo.clazz;

/**
 * @author yangzyh
 * @date 2021/4/12 14:03
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world";
}
