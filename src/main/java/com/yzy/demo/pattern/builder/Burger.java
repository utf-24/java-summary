package com.yzy.demo.pattern.builder;

/**
 * @author young
 * @date 2019/8/8 20:41
 */
public abstract class Burger implements Item {

    @Override
    public Packing getPacking() {
        return new Wrapper();
    }

}
