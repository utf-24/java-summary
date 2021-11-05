package com.yzy.demo.algorithm.offer;

/**
 * offer 10
 * @author yangzyh
 * @date 2021/11/4 20:44
 */
public class FibDemo {
    public int fib(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        int fibn = 0;
        int fibNMinus1 = 1;
        int fibNMinus2 = 0;
        for (int i = 2; i <= n; i++) {
            fibn = fibNMinus1 + fibNMinus2;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibn;
        }

        return fibn;
    }



    public static void main(String[] args) {
    }
}
