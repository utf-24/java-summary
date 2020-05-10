package com.yzy.demo.pattern.behavior.templete;

/**
 * @author yangzyh
 * @date 2020/5/10 11:10
 */
public class FootBall extends Game {
    @Override
    void initialize() {
        System.out.println("football initialize...");
    }

    @Override
    void start() {
        System.out.println("start play football");
    }

    @Override
    void end() {
        System.out.println("finish football");
    }
}
