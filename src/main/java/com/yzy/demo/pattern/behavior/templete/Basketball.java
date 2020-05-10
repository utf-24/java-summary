package com.yzy.demo.pattern.behavior.templete;

/**
 * @author yangzyh
 * @date 2020/5/10 11:06
 */
public class Basketball extends Game {
    @Override
    void initialize() {
        System.out.println("initialize basketball");
    }

    @Override
    void start() {
        System.out.println("let's play basketball");
    }

    @Override
    void end() {
        System.out.println("basketball game finished");
    }
}
