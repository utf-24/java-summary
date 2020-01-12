package com.yzy.demo.pattern.abstarctfactory;

/**
 * @author young
 * @date 2019/7/5 9:18
 */
public class AdidasShoes implements Shoes {

    static final String description = "this is shoes of adidas";

    @Override
    public String getDescription() {
        return description;
    }
}
