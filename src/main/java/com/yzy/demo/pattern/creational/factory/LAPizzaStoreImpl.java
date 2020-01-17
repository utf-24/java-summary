package com.yzy.demo.pattern.creational.factory;

import com.yzy.demo.pattern.creational.LACheesePizzaImpl;
import com.yzy.demo.pattern.creational.Pizza;

/**
 * @author young
 * @date 2020/1/18 1:26
 */
public class LAPizzaStoreImpl extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if( type.equalsIgnoreCase("cheese")) {
            return new LACheesePizzaImpl();
        }

        return null;
    }
}
