package com.yzy.demo.pattern.creational.factory.abstractFactory;

/**
 * 生产披萨原料的工厂，每个原料都定义一个工厂方法，
 * @author young
 * @date 2020/1/18 23:43
 */
public interface PizzaIngredientFactory {

    /**产品族1
     * @return beef
     */
    Beef createBeef();

    /**产品族2
     * @return cheese
     */
    Cheese createCheese();

}
