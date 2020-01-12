package com.yzy.demo.pattern.Builder;

/**
 * @author young
 * @date 2019/8/8 20:48
 */
public class VegBurger extends Burger {
    @Override
    public String getName() {
        return "vegBurger";
    }

    @Override
    public float getPrice() {
        return 15.0f;
    }
}
