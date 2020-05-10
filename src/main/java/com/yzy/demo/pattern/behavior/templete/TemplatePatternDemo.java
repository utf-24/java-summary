package com.yzy.demo.pattern.behavior.templete;

/**
 * 模板模式
 *
 * @author yangzyh
 * @date 2020/5/10 11:08
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Basketball();
        game.initialize();
        game.start();
        game.end();

        game = new FootBall();
        game.initialize();
        game.start();
        game.end();
    }
}
