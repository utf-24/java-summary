package com.yzy.demo.pattern.factorymethod;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * 工厂方法
 *
 * @author young
 * @date 2019/6/30 9:39
 */
@Data
public class FactoryMethodApp {

    private FoodFactory foodFactory;

    public FactoryMethodApp(FoodFactory foodFactory){
        this.foodFactory = foodFactory;
    }

    public static void main(String[] args) {
        // go to kfc
        FactoryMethodApp app = new FactoryMethodApp(new KFCFoodFactory());
        app.produceFood();

        // go to mcdonald
        app = new FactoryMethodApp(new McdonaldFactory());
        app.produceFood();
    }

    public void produceFood(){
        Food food;
        food = foodFactory.makeFood(FoodType.DOUBLE_BEFF_BURGER);
        System.out.println("get food: "+food);
        food = foodFactory.makeFood(FoodType.FRENCH_FRIES);
        System.out.println("get food: "+food);
        food = foodFactory.makeFood(FoodType.ICE_CREAM);
        System.out.println("get food: "+food);

    }
}
