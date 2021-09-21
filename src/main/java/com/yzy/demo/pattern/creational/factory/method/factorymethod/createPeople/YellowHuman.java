package com.yzy.demo.pattern.creational.factory.method.factorymethod.createPeople;

/**
 * @author yangzyh
 * @date 2021/9/21 19:41
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("color is yellow");
    }

    @Override
    public void talk() {
        System.out.println("你好");
    }
}
