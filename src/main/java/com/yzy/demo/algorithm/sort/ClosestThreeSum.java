package com.yzy.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * https://leetcode.cn/problems/3sum-closest/solutions/301382/zui-jie-jin-de-san-shu-zhi-he-by-leetcode-solution/
 * 空间 nlogn
 * 时间 n2
 * @author yangzyh
 * @date 2023/10/7 20:02
 */
public class ClosestThreeSum {
    public int threeSum(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 优化，减少第一层便利
                continue;
            }
            //双指针
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                int difference = Math.abs(sum - target);
                if ( Math.abs(closestSum - target) > difference) {
                    closestSum = sum;
                }
                if (sum > target) {
                    int kTemp = k - 1;
                    while (j < kTemp && nums[kTemp - 1] == nums[k]) {
                        kTemp--;
                    }
                    k = kTemp;
                } else {
                    int jTemp = j + 1;
                    while (jTemp < k && nums[jTemp] == nums[j]) {
                        jTemp++;
                    }
                    j = jTemp;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
        System.out.println(new ClosestThreeSum().threeSum(nums, -14));
    }
}
