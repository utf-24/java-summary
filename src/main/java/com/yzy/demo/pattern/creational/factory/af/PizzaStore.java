package com.yzy.demo.pattern.creational.factory.af;


/**
 * @author young
 * @date 2020/1/18 1:19
 */
public abstract class PizzaStore {

    /**
     * 工厂方法，把对象的实例化延迟到子类；
     * @param type
     * @return
     */
    public abstract Pizza createPizza(String type);

    /**
     * orderPizza方法与创建pizza的方法解耦，由子类决定
     * @param type
     * @return
     */
    public Pizza orderPizza(String type){
        // pizza创建解耦
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        System.out.println("sever pizza: "+pizza.getBeef().getName()
                + " " + pizza.getCheese().getName());

        return  pizza;
    }
}
