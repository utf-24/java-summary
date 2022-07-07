package com.yzy.demo.algorithm.search;

import java.util.Arrays;

/**
 * e.g. input: 4,-5,1,-3,2,6,1  output: 9
 * @author yangzyh
 * @date 2022/7/7 12:20
 */
public class FindMaxSubArray {

    int findMaxSubArray(int[] nums) {
        int[] result = doFindMaxSubArray(nums, 0, nums.length - 1);
        return  result[2];
    }

    /**
     *
     * @param nums
     * @param low
     * @param high
     * @return int[] a , a[0]:nums子数组起点， a[1]: nums子数组终点， a[2]: 子数组和
     */
    int[] doFindMaxSubArray(int[] nums, int low, int high) {
        if (low == high) {
            return new int[]{low, high, nums[low]};
        }
        int mid = (low + high) / 2;
        int[] leftMaxSubArray = doFindMaxSubArray(nums, low, mid);
        int[] rightMaxSubArray = doFindMaxSubArray(nums, mid + 1, high);
        int[] crossMaxSubArray = findCrossSubArray(nums, low, high);
        if (leftMaxSubArray[2] >= rightMaxSubArray[2] && leftMaxSubArray[2] >= crossMaxSubArray[2]) {
            return leftMaxSubArray;
        } else if (rightMaxSubArray[2] >= leftMaxSubArray[2] && rightMaxSubArray[2] >= crossMaxSubArray[2]) {
            return rightMaxSubArray;
        } else {
            return crossMaxSubArray;
        }
    }

    /**
     * 跨越了mid元素的最大子数组和
     * @param nums
     * @param low
     * @param high
     * @return int[] a , a[0]:nums子数组起点， a[1]: nums子数组终点， a[2]: 子数组和
     */
    private int[] findCrossSubArray(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        int maxLeftSum = Integer.MIN_VALUE;
        int leftSum = 0;
        int leftIndex = mid;
        for (int i = mid; i >= low ; i--) {
            leftSum += nums[i];
            if (leftSum > maxLeftSum) {
                maxLeftSum = leftSum;
                leftIndex = i;
            }
        }
        int maxRightSum = Integer.MIN_VALUE;
        int rightSum = 0;
        int rightIndex = mid;
        for (int i = mid; i <=high ; i++) {
            rightSum += nums[i];
            if (rightSum > maxRightSum) {
                maxRightSum = rightSum;
                rightIndex = i;
            }
        }

        return new int[]{leftIndex, rightIndex, (maxLeftSum + maxRightSum - nums[mid]) } ;// mid加了两次
    }

    public static void main(String[] args) {
        System.out.println(new FindMaxSubArray().findMaxSubArray(new int[]{4, -5, 1, -3, 2, 6, 1}));
        System.out.println(new FindMaxSubArray().findMaxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
