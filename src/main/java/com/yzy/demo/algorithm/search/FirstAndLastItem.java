package com.yzy.demo.algorithm.search;

/**
 * LC 34
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * @author yangzyh
 * @date 2022/4/24 23:27
 */
public class FirstAndLastItem {
    public int[] searchRange(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return getFirstAndLastPosition(nums, mid, target);
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int[] getFirstAndLastPosition(int[] nums, int index, int target) {
        int first = index, last = index;
        while ( first > 0 && nums[first - 1] == target) {
            first--;
        }
        while (last < nums.length - 1 && nums[last + 1] == target) {
            last++;
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] result = new FirstAndLastItem().searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(result);
    }
}
