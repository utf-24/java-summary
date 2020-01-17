package com.yzy.demo.pattern.creational.factory.method;

import com.yzy.demo.pattern.creational.factory.LAPizzaStoreImpl;
import com.yzy.demo.pattern.creational.factory.NYPizzaStoreImpl;

/**
 * 工厂方法测试
 *
 * @author young
 * @date 2020/1/18 1:27
 */
public class MethodFactoryDemo {
    public static void main(String[] args) {
        LAPizzaStoreImpl laPizzaStore = new LAPizzaStoreImpl();
        laPizzaStore.orderPizza("cheese");

        NYPizzaStoreImpl nyPizzaStore = new NYPizzaStoreImpl();
        nyPizzaStore.orderPizza("cheese");
    }
}
