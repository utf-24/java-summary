package com.yzy.demo.jvm.classload;

/**
 * @author young
 * @date 2019/6/9 10:15
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("subClass init");
    }
}
