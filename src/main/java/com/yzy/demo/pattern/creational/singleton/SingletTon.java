package com.yzy.demo.pattern.creational.singleton;

/**
 * 饿汉模式
 * @author young
 * @date 2019/10/15 15:43
 */
public class SingletTon {

    private int a = 1;

    private int b = 5;

    private SingletTon() {
    }

    private static final SingletTon INSTANCE = new SingletTon();

    public static SingletTon getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SingletTon s = SingletTon.getInstance();
        SingletTon s2 = SingletTon.getInstance();
        if(s.equals(s2)){
            System.out.println("equals");
        }
    }

}
