package com.yzy.demo.pattern.builder;

/**
 * @author young
 * @date 2019/8/8 20:45
 */
public class Pepsi extends Drink {

    @Override
    public String getName() {
        return "Pepsi";
    }

    @Override
    public float getPrice() {
        return 3.0f;
    }
}
