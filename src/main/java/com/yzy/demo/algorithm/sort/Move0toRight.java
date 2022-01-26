package com.yzy.demo.algorithm.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author yangzyh
 * @date 2022/1/26 16:10
 */
public class Move0toRight {

    /**
     * O(n) 不太容易想到
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }


    /**
     * O(n2) 复杂度太高了
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int n = nums.length-1;
        for (int i = n; i >=0; i--) {
            if (nums[i] == 0 && i < n && nums[i+1] !=0) {
                for (int j = i; j < n ; j++) {
                    nums[j] = nums[j+1];
                }
                nums[n] = 0;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,3,12};
        new Move0toRight().moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
