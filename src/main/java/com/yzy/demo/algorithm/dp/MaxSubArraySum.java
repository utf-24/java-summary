package com.yzy.demo.algorithm.dp;

/**
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 时间：O(n)
 * 空间：O(1)
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author yangzyh
 * @date 2021/12/31 0:42
 */
public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        if( nums.length < 1) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num: nums) {
            if (curSum < 0) {
                curSum = num;
            } else {
                curSum += num;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArraySum().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
