package com.yzy.demo.pattern.creational.factory.method.factorymethod.createPeople;

import java.lang.reflect.Constructor;

/**
 * @author yangzyh
 * @date 2021/9/21 19:43
 */
public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            //human = (T)Class.forName(c.getName()).newInstance();
            human = c.getConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("createHuman error");
        }
        return (T) human;
    }
}
