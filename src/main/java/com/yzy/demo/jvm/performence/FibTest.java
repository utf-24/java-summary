package com.yzy.demo.jvm.performence;

import java.util.stream.IntStream;

/**
 * @author young
 * @date 2019/6/11 9:11
 */
public class FibTest {

    private double fibImpl(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("must be > 0");
        }
        if (n == 0) {
            return 0d;
        }
        if (n == 1) {
            return 1d;
        }
        double d = fibImpl(n - 2) + fibImpl(n - 1);
        if (Double.isInfinite(d)) {
            throw new ArithmeticException("overflow");
        }

        return d;
    }

    public void doTest(){
        double l;
        long old = System.currentTimeMillis();
        for(int i = 0; i< 1;i++){
            l= fibImpl(50);
        }
        long now = System.currentTimeMillis();
        System.out.println(now-old);
    }


    public static void main(String[] args) {
        FibTest f = new FibTest();
        f.doTest();
    }
}
