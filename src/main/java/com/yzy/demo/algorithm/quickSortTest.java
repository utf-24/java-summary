package com.yzy.demo.algorithm;

import java.util.Arrays;

/**
 * @author young
 * @date 2019/8/13 14:05
 */
public class quickSortTest {

    private static void quickSort(int[] src, int left, int right) {
        // 出口
        if(left>right){
            return;
        }

        // 基准数
        int flag = src[left];
        int i = left, j = right, temp = 0;

        while (i != j) {
            while (src[j] >= flag && i < j) {
                j--;
            }
            while (src[i] <= flag && i < j) {
                i++;
            }
            if(i<j){
                temp = src[i];
                src[i] = src[j];
                src[j] = temp;
            }
        }
        // 基数归位
        src[left] = src[i];
        src[i] = flag;

        quickSort(src,left,i-1);
        quickSort(src,i+1,right);
    }
    public static void main(String[] args) {
        int[] a = {6, 1, 5, 2, 7, 4, 3, 10, 8, 9};
        quickSort(a,0,9);
        Arrays.stream(a).forEach(x -> System.out.println(x));
    }
}
