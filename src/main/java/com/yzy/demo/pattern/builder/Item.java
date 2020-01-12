package com.yzy.demo.pattern.builder;

/**
 * 商品接口
 *
 * @author young
 * @date 2019/8/8 20:40
 */
public interface Item {

    String getName();

    Packing getPacking();

    float getPrice();
}
