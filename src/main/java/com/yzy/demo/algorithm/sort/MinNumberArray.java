package com.yzy.demo.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 剑值offer 45
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @author yangzyh
 * @date 2021/6/20 18:00
 */
public class MinNumberArray {

    public String minNumber(int[] nums) {
        Integer[] input = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (Comparator) (a, b) -> {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String .valueOf(b) + String.valueOf(a);
            return ab.compareTo(ba);
        });
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            result.append(input[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] a = {3,32,321};
        System.out.println(new MinNumberArray().minNumber(a));
    }
}