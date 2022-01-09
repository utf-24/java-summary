package com.yzy.demo.algorithm.dp;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 和斐波那契数列不同的地方，f(0) = 1, f(2) = 2
 * @author yangzyh
 * @date 2022/1/9 15:35
 */
public class ClimbStair {
    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int nMinus2 = 0;
        int nMinus1 = 0;
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            nMinus2 = nMinus1;
            nMinus1 = cur;
            cur =  nMinus1 + nMinus2;
        }

        return cur;
    }

    public static void main(String[] args) {
        System.out.println(ClimbStair.climbStairs(4));
    }
}
