package com.yzy.demo.pattern.creational;

import java.util.Arrays;

/**
 * @author young
 * @date 2020/1/18 1:17
 */
public class LACheesePizzaImpl extends Pizza {
    public LACheesePizzaImpl(){
        this.name = "LAChessePizza";
        this.dough = "LADough";
        this.sauce = "LASauce";
        this.toppings = Arrays.asList("banana","fish");
    }
}
