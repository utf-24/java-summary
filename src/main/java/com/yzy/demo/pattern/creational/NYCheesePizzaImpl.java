package com.yzy.demo.pattern.creational;

import java.util.Arrays;

/**
 * @author young
 * @date 2020/1/18 1:13
 */
public class NYCheesePizzaImpl extends Pizza {
    public NYCheesePizzaImpl(){
        this.name = "NYChessePizza";
        this.dough = "NYDough";
        this.sauce = "NYSauce";
        this.toppings = Arrays.asList("apple","beef");
    }
}
