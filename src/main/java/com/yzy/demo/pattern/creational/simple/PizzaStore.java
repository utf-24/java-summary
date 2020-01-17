package com.yzy.demo.pattern.creational.simple;

/**
 * @author young
 * @date 2020/1/17 23:13
 * @see head first 设计模式
 */
public class PizzaStore {

    public Pizza orderPizza(String type) {
        // 用简单工厂把对象创建解耦
        Pizza pizza = SimplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        System.out.println("pizz is ready: "+ pizza.getName());

        return pizza;
    }

    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();
        store.orderPizza("beef");
    }
}
