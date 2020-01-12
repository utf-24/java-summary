package com.yzy.demo.pattern.factorymethod;

/**
 * @author young
 * @date 2019/6/30 9:55
 */
public class McdonaldFood implements Food {

    private FoodType foodType;

    public McdonaldFood(FoodType foodType){
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "mcdonald's: "+foodType;
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
    }
}
