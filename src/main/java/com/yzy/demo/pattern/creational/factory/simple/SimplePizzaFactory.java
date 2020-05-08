package com.yzy.demo.pattern.creational.factory.simple;

import com.yzy.demo.pattern.creational.factory.method.Pizza;

/**
 * 简单工厂，把客户端行为和对象创建过程分开
 * 缺点：不符合开闭原则
 * @author young
 * @date 2020/1/17 23:05
 */
public class SimplePizzaFactory {

    /**
     * 建议用static
     *
     * @param type
     * @return
     */
    public static Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case "beef":
                pizza = new BeefPizza();
                break;
            case "fruit":
                pizza = new FruitPizza();
                break;
            case "chicken":
                pizza = new ChickenPizza();
                break;
            default:
        }

        return pizza;
    }
}
