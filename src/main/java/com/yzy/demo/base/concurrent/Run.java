package com.yzy.demo.base.concurrent;

/**
 * @author young
 * @date 2019/5/19 19:36
 */
public class Run {
    public static void main(String[] args) {
//        ThreadNoShareVal a = new ThreadNoShareVal("a");
//        ThreadNoShareVal b = new ThreadNoShareVal("b");
//        ThreadNoShareVal c = new ThreadNoShareVal("c");
//        a.start();
//        b.start();
//        c.start();

        ThreadShareVal thread = new ThreadShareVal();
        Thread a = new Thread(thread,"a");
        Thread b = new Thread(thread,"b");
        Thread c = new Thread(thread,"c");
        Thread d = new Thread(thread,"d");
        Thread e = new Thread(thread,"e");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
