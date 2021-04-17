package com.yzy.demo.algorithm.sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yangzyh
 * @date 2021/4/17 10:00
 */
public class QuickSort {


    public static int[] sort(int[] array, int start, int end) {
        if(array==null || array.length <2 || start == end) {
            return array;
        }
        int index = portion(array, start, end);
        if(index > start) {
            sort(array, start, index -1);
        }
        if(index < end) {
            sort(array, index +1, end);
        }

        return array;
    }

    private static int portion(int[] array, int start, int end) {
        // 在start-end范围内任选一个下标
        int index = ThreadLocalRandom.current().nextInt (end-start + 1) + start;
        int small = start - 1;
        swap(array, index, end);
        for(index = start; index < end; index++) {
            if(array[index] < array[end]) {
                small++;
                if(small !=index) {
                    swap(array, small, index);
                }
            }
        }
        small++;
        swap(array, small, end);

        return small;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5,2 ,3,1, 4};
        sort(a,0,4);
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]);
        }
    }
}
