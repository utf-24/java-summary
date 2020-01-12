package com.yzy.demo.annotation;

/**
 * @author young
 * @date 2019/5/30 19:49
 */
public class Apple {
    @FruitProvider(id = 1,  address = "陕西省西安市延安路")
    private String appleProvider;

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }
}