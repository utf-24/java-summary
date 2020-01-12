package com.yzy.demo.pattern.abstarctfactory;

/**
 * @author young
 * @date 2019/7/5 9:14
 */
public class AdidasCoat implements Coat {

    String description = "this is coat of adidas";

    @Override
    public String getDescription() {
        return description;
    }
}
