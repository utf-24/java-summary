package com.yzy.demo.pattern.creational.factory.af;

/**
 * @author young
 * @date 2020/1/18 23:46
 */
public class NYPizzaIngredientFactoryImpl implements PizzaIngredientFactory {
    @Override
    public Beef createBeef() {
        return new NYBeefImpl();
    }

    @Override
    public Cheese createCheese() {
        return new NYCheeseImpl();
    }
}
