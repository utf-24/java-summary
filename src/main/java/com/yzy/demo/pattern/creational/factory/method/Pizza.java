package com.yzy.demo.pattern.creational.factory.method;

import java.util.List;

/**
 * @author young
 * @date 2020/1/17 23:03
 */
public abstract class Pizza {
     String name;
     String sauce;
     String dough;
     List<String> toppings;

    public void prepare() {
        System.out.println("tossing dough "+dough);
        System.out.println("adding sauce "+ sauce);
        for(String topping : toppings) {
            System.out.println("adding topping " +topping);
        }
    }

    public void bake() {
        System.out.println("common bake");
    }

    public void cut() {
        System.out.println("common cut");
    }

    public String getName() {
        return name;
    }
}
