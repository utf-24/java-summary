package com.yzy.demo.pattern.structural.decorator;

/**
 * 抽象装饰者
 *
 * @author yangzyh
 * @date 2020/5/10 11:41
 */
public abstract class ShapeDecorator implements Shape {

    /**
     * 负责装饰Shape接口
     */
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
