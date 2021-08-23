package com.yzy.demo.algorithm.offer;

import java.util.Arrays;

/**
 * 剑指offer 57
 *
 * @author yangzyh
 * @date 2021/8/23 20:40
 */
public class SumOfS {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return  result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
        System.out.println(Arrays.toString(new SumOfS().twoSum(a, 15)));
    }
}



