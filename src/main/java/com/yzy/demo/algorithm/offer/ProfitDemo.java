package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 63
 * man~ this is the first time you solve it by yourself, dope~~
 * @author yangzyh
 * @date 2021/10/11 22:07
 */
public class ProfitDemo {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int min = prices[0];
        int max = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > max) {
                max = prices[i];
               int currentProfit = prices[i] - min;
               if(currentProfit> maxProfit){
                   maxProfit = currentProfit;
               }
            } else if(prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }

        return  maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new ProfitDemo().maxProfit(prices));
    }
}
