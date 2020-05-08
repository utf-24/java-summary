package com.yzy.demo.pattern.creational.factory.abstractFactory;

/**
 * @author young
 * @date 2020/1/18 23:53
 */
public class CheesePizzaImpl extends Pizza {

    /**
     *  pizza原料工厂
     */
    private PizzaIngredientFactory factory;

    public CheesePizzaImpl(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    void prepare() {
        System.out.println("prearing " + name);
        // 使用原料工厂
        beef = factory.createBeef();
        cheese = factory.createCheese();
    }
}
