package com.yzy.demo.pattern.structural.decorator;

/**
 * @author yangzyh
 * @date 2020/5/10 11:39
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: rectanle");
    }
}
