package com.yzy.demo.pattern.Builder;

/**
 * @author young
 * @date 2019/8/8 20:42
 */
public abstract class Drink implements Item {

    @Override
    public Packing getPacking() {
        return new Bottel();
    }

}
