package com.yzy.demo.pattern.creational.factory.method.factorymethod.createPeople;

/**
 * @author yangzyh
 * @date 2021/9/21 19:41
 */
public abstract class  AbstractHumanFactory {
    public abstract  <T extends Human> T createHuman(Class<T> c);
}
