package com.yzy.demo.pattern.creational.builder;

/**
 * @author young
 * @date 2019/8/8 20:46
 */
public class Coke extends Drink {
    @Override
    public String getName() {
        return "coke";
    }

    @Override
    public float getPrice() {
        return 2.8f;
    }
}
