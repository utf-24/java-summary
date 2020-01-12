package com.yzy.demo.controller;

/**
 * @author young
 * @date 2019/5/19 20:46
 */
public class LoginA extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("a","aa");
    }
}
