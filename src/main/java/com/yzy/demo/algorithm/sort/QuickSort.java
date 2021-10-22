package com.yzy.demo.algorithm.sort;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static void sort2(List<Integer> items) {
        if(items.size() > 1) {
            List<Integer> small = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> big = new ArrayList<>();
            int pivot = items.get(ThreadLocalRandom.current().nextInt(items.size()));
            for (Integer item:items) {
                if(item < pivot) {
                    small.add(item);
                } else if(item == pivot) {
                    same.add(item);
                } else {
                    big.add(item);
                }
            }

            sort2(small);
            sort2(big);

            items.clear();
            items.addAll(small);
            items.addAll(same);
            items.addAll(big);
        }
    }


    public static void main(String[] args) {
        Integer[] a = {5,2 ,3,1, 4};
        //sort(a,0,4);
        //for (int i = 0; i <a.length ; i++) {
        //    System.out.print(a[i]);
        //}
        List list = new ArrayList<>(Arrays.asList(a));
        sort2(list);
        System.out.println(list);
    }
}
