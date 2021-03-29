package com.yzy.demo.util;

/**
 * @author yangzyh
 * @date 2021/3/29 23:08
 */
public class AlgorithmUtils {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
