package com.yzy.demo.pattern.creational.factory.af;

/**
 * @author young
 * @date 2020/1/19 0:00
 */
public class NYPizzaStoreImpl extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // 使用特定工厂的原料
        PizzaIngredientFactory factory = new NYPizzaIngredientFactoryImpl();
        if(type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizzaImpl(factory);
            pizza.setName("NY's cheese pizza");
            return  pizza;
        }

        return null;
    }
}
