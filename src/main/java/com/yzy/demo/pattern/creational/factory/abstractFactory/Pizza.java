package com.yzy.demo.pattern.creational.factory.abstractFactory;

import lombok.Data;

/**
 * @author young
 * @date 2020/1/18 23:31
 */
@Data
public abstract class Pizza {
    Cheese cheese;
    String name;
    Beef beef;

    /**
     *  原料来自原来工厂
     */
    abstract void prepare();

    void bake(){
        System.out.println("common bake");
    }

    void cut() {
        System.out.println("common cut");
    }


}
