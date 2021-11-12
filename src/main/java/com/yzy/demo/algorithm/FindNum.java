package com.yzy.demo.algorithm;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 考察优化时间复杂度的算法
 *
 * @author yangzyh
 * @date 2021/3/20 19:36
 */
public class FindNum {
    public int majorityElement(int[] nums) {
        if(nums.length ==1) return nums[0];
        int start =0, end = nums.length-1;
        int index = partition(nums,start, end);
        int mid = nums.length >>1;
        while (index !=mid && start < end) {
            if(index < mid) {
                start = index+1;
            } else {
                end = index-1;
            }
            if(start == end) break;
            index = partition(nums, start, end);
        }

        return nums[mid];
    }

    /**
     * 不改变数组,更推荐此法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int result = nums[0];
        int times = 1;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i] != result) {
                times--;
                if(times == 0) {
                    result = nums[i];
                    times = 1;
                }
            } else {
                times++;
            }
        }

        return result;
    }

    /**
     * 选出数组其中一个元素，比他大的排右边，比他小的排左边
     * @param nums
     * @return 选择元素在排序后数组的下标
     */
    private int partition(int[] nums, int start, int end) {
        // 重要
        int small = start-1;
        int pivot = ThreadLocalRandom.current().nextInt(start, end);
        swap(nums, pivot, end);
        for (int i = start; i< end; i++) {
            if(nums[i] < nums[end]) {
                small++;
                if(i!=small) {
                    swap(nums, i, small);
                }
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int pivot, int end) {
        int temp = nums[pivot];
        nums[pivot] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3,3,4};
        System.out.println(new FindNum().majorityElement(a));
        System.out.println(new FindNum().majorityElement2(a));
    }
}
