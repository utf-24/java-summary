package com.yzy.demo.base;

/**
 * 验证String 在常量池存储方式
 * @author young
 * @date 2020/3/11 21:50
 */
public class TestString {
    public static void main(String[] args) {
        String s1 = new String("Java");
        String s2 = s1.intern();
        String s3 = "Java";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);

    }
}
