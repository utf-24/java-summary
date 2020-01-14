package com.yzy.demo.jvm.classload;

/**
 * @author young
 * @date 2019/6/9 10:16
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO_WORLD);
    }
}
