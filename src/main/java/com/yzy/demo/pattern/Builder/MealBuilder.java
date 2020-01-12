package com.yzy.demo.pattern.Builder;

import com.yzy.demo.pattern.adaptor.MediaPlayer;

/**
 * @author young
 * @date 2019/8/8 20:54
 */
public class MealBuilder {
    public Meal makeVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal makeNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
