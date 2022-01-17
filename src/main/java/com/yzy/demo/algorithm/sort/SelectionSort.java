package com.yzy.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author yangzyh
 * @date 2022/1/17 15:04
 */
public class SelectionSort {

    public void sort(Comparable[] src) {
        for (int i = 0; i < src.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < src.length; j++) {
                if (less(src[j], src[minIdx])) {
                    minIdx = j;
                }
            }
            if(minIdx != i) {
                swap(src, minIdx, i);
            }
        }
    }

    private void swap(Comparable[] src, int minIdx, int i) {
        Comparable swap = src[minIdx];
        src[minIdx] = src[i];
        src[i] = swap;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        String[] a = {"b","sfd","z","sf","k"};
        new SelectionSort().sort(a);
        System.out.println(Arrays.toString(a));
    }
}