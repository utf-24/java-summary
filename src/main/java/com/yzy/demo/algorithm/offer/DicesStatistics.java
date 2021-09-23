package com.yzy.demo.algorithm.offer;

import java.util.Arrays;

/**
 *     作者：jyd
 *     链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
 *     来源：力扣（LeetCode）
 *     剑指offer60
 *     n 个骰子「点数和」的范围为 [n, 6n]，数量为 6n - n + 1 =5n+1 种。
 * @author yangzyh
 * @date 2021/9/23 10:45
 */
public class DicesStatistics {
    /**
     * TODO: 没懂
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DicesStatistics().dicesProbability(3)));
    }
}
