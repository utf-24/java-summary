package com.yzy.demo.algorithm.search;

/**
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * @author yangzyh
 * @date 2022/5/12 21:45
 */
public class FindNumCount {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                int firstIdx = mid;
                int lastIdx = mid;
                while (firstIdx > 0 && nums[firstIdx - 1] == target) {
                    firstIdx--;
                }
                while (lastIdx < nums.length - 1 && nums[lastIdx + 1] == target) {
                    lastIdx++;
                }
                return lastIdx - firstIdx + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindNumCount().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
