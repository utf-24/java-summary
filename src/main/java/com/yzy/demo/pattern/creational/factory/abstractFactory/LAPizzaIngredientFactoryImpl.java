package com.yzy.demo.pattern.creational.factory.abstractFactory;

/**
 * @author young
 * @date 2020/1/18 23:48
 */
public class LAPizzaIngredientFactoryImpl implements PizzaIngredientFactory {
    @Override
    public Beef createBeef() {
        return new LABeefImpl();
    }

    @Override
    public Cheese createCheese() {
        return new LACheeseImpl();
    }
}
