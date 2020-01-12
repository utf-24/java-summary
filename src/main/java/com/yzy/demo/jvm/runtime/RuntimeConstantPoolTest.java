package com.yzy.demo.jvm.runtime;

/**
 * @author young
 * @date 2019/6/6 13:54
 */
public class RuntimeConstantPoolTest {
    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        char c [ ] = {'h','e','l','l','o'};
        System.out.println(s.equals(t));
        System.out.println(t.equals(c));
        System.out.println( t == (new String("hello")));

    }
}
