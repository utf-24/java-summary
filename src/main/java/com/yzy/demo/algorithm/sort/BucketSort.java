package com.yzy.demo.algorithm.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * simple version
 *
 * @author young
 * @date 2019/8/12 19:16
 */
public class BucketSort {
    public static void sort(int[] src, int range) {
        int[] bucket = new int[range + 1];
        Arrays.stream(src).forEach(i -> bucket[i]++);

        for(int j = 0 ; j< bucket.length;j++) {
            for(int k = 0; k< bucket[j];k++){
                System.out.println(j);
            }
        }
    }
    public static void main(String[] args) {
        int[] src = {8, 2, 5, 5, 1, 6};
        sort(src, 10);
    }
}
