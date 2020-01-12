package com.yzy.demo.pattern.builder;

/**
 * 包装纸
 *
 * @author young
 * @date 2019/8/8 20:38
 */
public class Wrapper implements Packing {
    @Override
    public String packing() {
        return "packing with wrapper";
    }
}
