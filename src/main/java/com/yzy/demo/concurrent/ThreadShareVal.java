package com.yzy.demo.concurrent;

/**
 * @author young
 * @date 2019/5/19 20:15
 */
public class ThreadShareVal extends Thread {
    private  int count = 5;

    @Override
    public void  run() {
        super.run();
        count--;
        System.out.println("线程" +this.getName() + "计算,count = " +count);
    }
}
