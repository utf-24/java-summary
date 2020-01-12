package com.yzy.demo.pattern.abstarctfactory;

/**
 * @author young
 * @date 2019/7/5 9:50
 */
public class NikeBag implements Bag {

    static final String description = "this is nike's Bag";

    @Override
    public String getDescription() {
        return description;
    }
}
