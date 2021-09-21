package com.yzy.demo.pattern.creational.factory.method.factorymethod.createPeople;

/**
 * @author yangzyh
 * @date 2021/9/21 19:40
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("color is white");
    }

    @Override
    public void talk() {
        System.out.println("hello~");
    }
}
