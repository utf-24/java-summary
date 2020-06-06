package com.yzy.demo.concurrent.jcip.chapter6;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 错误的timer行为
 * timer不会捕获异常，导致后续的任务将不会再执行。
 *
 * @author yangzyh
 * @date 2020/6/6 10:38
 */
public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);
        System.out.println("here");
    }

    static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
