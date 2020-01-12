package com.yzy.demo.controller;

/**
 * @author young
 * @date 2019/5/19 20:48
 */
public class LoginTest {
    public static void main(String[] args) {
        System.out.println("current thread: "+Thread.currentThread().getName());
        LoginA loginA = new LoginA();
        loginA.start();
        LoginB loginB = new LoginB();
        loginB.start();
    }
}
