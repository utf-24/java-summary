package com.yzy.demo.pattern.structural.decorator;

/**
 * @author yangzyh
 * @date 2020/5/10 11:44
 */
public class RedShapeDecoratorImpl extends ShapeDecorator {
    public RedShapeDecoratorImpl(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("border color: red");
    }
}
