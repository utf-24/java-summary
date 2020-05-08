package com.yzy.demo.pattern.creational.factory.abstractFactory;

/**
 * @author young
 * @date 2020/1/18 23:56
 */
public class BeefPizzaImpl extends Pizza {

    private PizzaIngredientFactory factory;

    public BeefPizzaImpl(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    void prepare() {
        beef = factory.createBeef();
        cheese = factory.createCheese();
    }
}
