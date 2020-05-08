package com.yzy.demo.pattern.creational.factory.method.factorymethod;


public enum FoodType {
    DOUBLE_BEFF_BURGER("double beef burger"), FRENCH_FRIES("french fries"),
    ICE_CREAM("ice cream");

    private String title;

    FoodType(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return title;
    }
}
