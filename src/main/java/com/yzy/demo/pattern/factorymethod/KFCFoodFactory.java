package com.yzy.demo.pattern.factorymethod;

/**
 * @author young
 * @date 2019/6/30 9:50
 */
public class KFCFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(FoodType foodType) {
        return new KFCFood(foodType);
    }
}
