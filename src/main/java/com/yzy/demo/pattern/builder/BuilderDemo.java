package com.yzy.demo.pattern.builder;

/**
 * @author young
 * @date 2019/8/8 20:57
 */
public class BuilderDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.makeNonVegMeal();
        meal.showItems();
        System.out.println(meal.getPrice());
        meal = mealBuilder.makeVegMeal();
        meal.showItems();
        System.out.println(meal.getPrice());

    }
}
