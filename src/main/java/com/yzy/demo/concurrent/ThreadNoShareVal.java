package com.yzy.demo.concurrent;

/**
 * @author young
 * @date 2019/5/19 19:22
 */
public class ThreadNoShareVal  extends Thread{
    private int count = 5;

    public ThreadNoShareVal(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while(count > 0){
            count--;
            System.out.println("线程" +this.getName() + "计算,count = " +count);
        }
    }
}
