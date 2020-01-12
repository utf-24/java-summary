package com.yzy.demo.pattern.abstarctfactory;

/**
 * @author young
 * @date 2019/7/5 9:12
 */
public class NikeCoat implements Coat {

    String description = "this is nike's coat";

    @Override
    public String getDescription() {
        return description;
    }
}
