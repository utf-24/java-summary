package com.yzy.demo.pattern.creational.simple;

/**
 * @author young
 * @date 2020/1/17 23:03
 */
public abstract class Pizza {

    public String getName(){
        return this.getClass().getName();
    }

    public void prepare() {
        System.out.println("common prepare");
    }

    public void bake() {
        System.out.println("common bake");
    }

    public void cut() {
        System.out.println("common cut");
    }

}
