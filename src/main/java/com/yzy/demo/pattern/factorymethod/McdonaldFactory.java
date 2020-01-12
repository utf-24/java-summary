package com.yzy.demo.pattern.factorymethod;

/**
 * @author young
 * @date 2019/6/30 9:58
 */
public class McdonaldFactory implements FoodFactory {

    @Override
    public Food makeFood(FoodType foodType) {
        return new McdonaldFood(foodType);
    }
}
