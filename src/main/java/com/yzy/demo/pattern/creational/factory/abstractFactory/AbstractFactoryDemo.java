package com.yzy.demo.pattern.creational.factory.abstractFactory;

/**
 * 抽象工厂测试类
 *
 * @author young
 * @date 2020/1/18 23:49
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStoreImpl();
        pizzaStore.orderPizza("cheese");
    }
}
