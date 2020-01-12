package com.yzy.demo.pattern.abstarctfactory;

/**
 * @author young
 * @date 2019/7/5 9:17
 */
public class NikeShoes implements Shoes {

    static final String description = "this is nike's shoes";

    @Override
    public String getDescription() {
        return description;
    }
}
