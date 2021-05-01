package com.yzy.demo.algorithm;

/**
 * 剑指offer 42 最大子数组的和
 *
 * @author yangzyh
 * @date 2021/5/1 14:54
 */
public class MaxSubArrayFinder {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxCount = Integer.MIN_VALUE, currentCount = 0;
        for (int num : nums) {
            if (currentCount < 0) {
                currentCount = num;
            } else {
                currentCount += num;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(new MaxSubArrayFinder().maxSubArray(nums));
    }
}
