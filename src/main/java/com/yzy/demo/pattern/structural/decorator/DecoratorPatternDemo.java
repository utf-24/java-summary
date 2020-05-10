package com.yzy.demo.pattern.structural.decorator;

/**
 * 装饰者模式示例
 *
 * @author yangzyh
 * @date 2020/5/10 11:46
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecoratorImpl(circle);
        circle.draw();
        System.out.println("----");
        redCircle.draw();
    }
}
