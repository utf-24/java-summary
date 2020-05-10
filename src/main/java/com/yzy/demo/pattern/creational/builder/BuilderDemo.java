package com.yzy.demo.pattern.creational.builder;

/**
 * 建造者模式通过不同的小的操作，搭配，建造整体的对象，比如麦当劳的各种套餐。
 * 优点：建造者独立，易拓展。便于控制细节风险
 * 缺点：产品必须有共同点，范围有限制
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
