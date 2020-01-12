package com.yzy.demo.pattern.factorymethod;

/**
 * @author young
 * @date 2019/6/30 9:48
 */
public interface FoodFactory {
    Food makeFood(FoodType foodType);
}
