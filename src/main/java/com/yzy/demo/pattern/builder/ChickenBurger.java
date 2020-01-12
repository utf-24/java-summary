package com.yzy.demo.pattern.builder;

/**
 * @author young
 * @date 2019/8/8 20:49
 */
public class ChickenBurger extends Burger {
    @Override
    public String getName() {
        return "chickenBurger";
    }

    @Override
    public float getPrice() {
        return 20.f;
    }
}
