package com.yzy.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author yangzyh
 * @date 2022/1/17 15:30
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                swap(a,j,j-1);
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] src, int minIdx, int i) {
        Comparable swap = src[minIdx];
        src[minIdx] = src[i];
        src[i] = swap;
    }

    public static void main(String[] args) {
        Integer[] a = {3,2,11,1,34,33,22};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
