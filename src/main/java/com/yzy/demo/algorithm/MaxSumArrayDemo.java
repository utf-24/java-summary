package com.yzy.demo.algorithm;

import java.util.Arrays;

/**
 * 求最大子集和
 *
 * @author young
 * @date 2020/2/24 21:20
 */
public class MaxSumArrayDemo {
    static int maximum(int[] array) {
        int result = 0;
        for (int i : array) {
            if (i > 0) {
                result += i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maximum(array));
    }
}
