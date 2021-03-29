package com.yzy.demo.algorithm.sort;

import com.yzy.demo.util.AlgorithmUtils;

import java.util.Arrays;

/**
 * @author yangzyh
 * @date 2021/3/29 23:02
 */
public class BubbleSort {
    private static int[] sort(int[] src) {
        boolean sorted = false;
        int length = src.length;
        while(!sorted) {
            // 使用排序标识可以减少扫描次数
            sorted = true;
            for (int i = 1; i < length; i++) {
                if(src[i-1] > src[i]) {
                    AlgorithmUtils.swap(src, i, i-1);
                    // 当进行了交换后，就不确定数组是否整体有序，需要修改标识
                    sorted = false;
                }
            }
            length--;
        }

        return src;
    }

    public static void main(String[] args) {
        int[] a = {3,44,32,11,14,3232,55,54,3};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
