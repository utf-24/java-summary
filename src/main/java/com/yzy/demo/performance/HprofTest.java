package com.yzy.demo.performance;

/**
 *
 * run: java -agentlib:hprof=cpu=times,interval=20,depth=3 com.yzy.demo.performance.HprofTest
 * @author young
 * @date 2019/7/25 19:35
 */
public class HprofTest {

    public void action1(){
        try {
            System.out.println("action1 run");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void action2(){
        try {
            System.out.println("action2 run");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HprofTest hprofTest = new HprofTest();
        hprofTest.action1();
        hprofTest.action2();
    }
}
