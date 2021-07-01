package com.yzy.demo.algorithm;

/**
 * 剑值offeer 45
 * 为啥递归从最小子集自下而上处理可以解决重复计算的问题？
 * f(i) = f(i+1) + g(i,i+1) * f(i+2);
 *
 * @author yangzyh
 * @date 2021/7/1 22:07
 */
public class Number2Letter {

    public int getTranslationCount(int input) {
        String inputStr = String.valueOf(input);
        //记录每一位的次数
        int[] counts = new int[inputStr.length()];
        int count = 0;
        int length =inputStr.length();
        for (int i = length-1; i >= 0; i--) {
            if(i < length-1) {
                count = counts[i+1];
            } else {
                count = 1;
            }
            if(i <length -1) {
                int digit1 = inputStr.charAt(i) -'0';
                int digit2 = inputStr.charAt(i+1) - '0';
                int convertNum = (digit1*10 + digit2);
                if(convertNum >=10 && convertNum <= 25) {
                    if(i < length-2) {
                        count += counts[i+2];
                    }else {
                        count +=1;
                    }
                }
            }
            counts[i] = count;
        }

        return counts[0];
    }

    public static void main(String[] args) {
        System.out.println(new Number2Letter().getTranslationCount(12258));
    }
}
