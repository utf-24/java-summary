package com.yzy.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 每次保证h长度的子数组有序
 * @author yangzyh
 * @date 2022/1/17 15:51
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        while (length/3 > h) {
            h = 3*h + 1;
        }
        while (h >= 1 ) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]) ; j -= h) {
                    swap(a, j, j-h);
                }
            }
            h = h/3;
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
        String[] a = {"b","sfd","z","sf","k"};
        Shell.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
