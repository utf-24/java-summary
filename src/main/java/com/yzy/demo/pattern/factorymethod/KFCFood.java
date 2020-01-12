package com.yzy.demo.pattern.factorymethod;

/**
 * @author young
 * @date 2019/6/30 9:51
 */
public class KFCFood implements Food {

    private  FoodType foodType;

    public KFCFood(FoodType type){
        this.foodType = type;
    }

    @Override
    public String toString() {
        return "kfc: "+ foodType;
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
    }
}
