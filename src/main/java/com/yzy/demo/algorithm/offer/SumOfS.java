package com.yzy.demo.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public int[][] findContinuousSequence(int target) {
        List<int[]> resultList = new ArrayList<>();
        int small = 1, big = 2;
        int mid = (target +1) /2;
        int curSum = small + big;
        while (small < mid) {
            if(curSum == target) {
                resultList.add(getArray(small, big));
            }
            while (curSum > target && small < mid) {
                curSum-=small;
                small++;
                if(curSum == target) resultList.add(getArray(small, big));
            }
            big++;
            curSum+=big;
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    private int[] getArray(int small, int big) {
        int[] array = new int[big-small +1];
        for(int i =small; i<big+1; i++) {
            array[i-small] = i;
        }
        return array;
    }

    public static void main(String[] args) {
        //int[] a = {1,2,4,7,11,15};
        //System.out.println(Arrays.toString(new SumOfS().twoSum(a, 15)));
        System.out.println(Arrays.deepToString(new SumOfS().findContinuousSequence(9)));
    }
}



