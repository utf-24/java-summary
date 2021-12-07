package com.yzy.demo.algorithm.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * @author yangzyh
 * @date 2021/12/8 0:08
 */
public class FindStartEndTarget {

    public int[] searchRange(int[] nums, int target) {
        int startIndex = binarySearch(nums, target, true);
        int endIndex = binarySearch(nums, target, false)-1;
        if(startIndex <= endIndex && endIndex < nums.length && nums[startIndex] == target && nums[endIndex] == target) {
            return new int[]{startIndex, endIndex};
        } else {
            return new int[] {-1,-1};
        }
    }

    /**
     * @param nums
     * @param target
     * @param lower true: 寻找第一个大于等于target的位置，false：寻找第一个大于target的位置
     * @return
     */
    private int binarySearch(int[] nums, int target, boolean lower) {
        int start = 0, end = nums.length-1,  resultIndex = nums.length;
        while (start <= end ) {
            int mid = (start + end)>>1;
            if((nums[mid] >target) ||(lower && nums[mid] >= target)) {
                end = mid - 1;
                resultIndex = mid;
            }else{
                start = mid + 1;
            }
        }
        return resultIndex;
    }
}
