package com.yzy.demo.controller;

/**
 * @author young
 * @date 2019/5/19 20:47
 */
public class LoginB extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("b","bb");
    }
}
