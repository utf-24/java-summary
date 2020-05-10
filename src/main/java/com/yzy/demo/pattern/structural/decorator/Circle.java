package com.yzy.demo.pattern.structural.decorator;

/**
 * @author yangzyh
 * @date 2020/5/10 11:40
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape: circle");
    }
}
