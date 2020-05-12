package com.yzy.demo.jvm.reference;

/**
 * @author young
 * @date 2019/8/13 10:43
 */
public class TestReference {
    public static void main(String[] args) {
        B b = new B();
        b.setbName("1");
        A a = new A();
        a.setB(b);
        b.setbName("2");
        System.out.println(a.getB().getbName());
    }
}
