package com.yzy.demo.pattern.creational.factory;

import com.yzy.demo.pattern.creational.NYCheesePizzaImpl;
import com.yzy.demo.pattern.creational.Pizza;

/**
 * @author young
 * @date 2020/1/18 1:24
 */
public class NYPizzaStoreImpl extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equalsIgnoreCase("cheese")) {
            return new NYCheesePizzaImpl();
        }

        return null;
    }
}
