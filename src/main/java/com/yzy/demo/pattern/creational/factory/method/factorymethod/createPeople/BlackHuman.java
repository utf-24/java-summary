package com.yzy.demo.pattern.creational.factory.method.factorymethod.createPeople;

/**
 * @author yangzyh
 * @date 2021/9/21 19:39
 */
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("color is black");
    }

    @Override
    public void talk() {
        System.out.println("what's up bro~");
    }
}
