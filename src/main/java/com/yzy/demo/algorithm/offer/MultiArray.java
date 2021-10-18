package com.yzy.demo.algorithm.offer;

import java.util.Arrays;

/**
 * 剑指offer 66
 * 排成矩阵，按对角线分成上下三角，分别相乘
 * @author yangzyh
 * @date 2021/10/18 23:05
 */
public class MultiArray {
    public int[] constructArr(int[] a) {
        if(a.length< 1) return a;
        int[] result = new int[a.length];
        result[0] =1;
        //计算下半三角
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i-1]* a[i-1];
        }
        //计算上半三角，并和下班三角的结果相乘
        int temp = 1;
        for (int i = a.length-2; i>=0 ; i--) {
            temp*=a[i+1];
            result[i]*=temp;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(new MultiArray().constructArr(a)));
    }
}
