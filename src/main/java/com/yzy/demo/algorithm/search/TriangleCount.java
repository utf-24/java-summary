package com.yzy.demo.algorithm.search;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-triangle-number/
 * LC 611
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * @author yangzyh
 * @date 2022/5/8 0:02
 */
public class TriangleCount {

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    k++;
                }
                ans += Math.max(k - j, 0);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        System.out.println(new TriangleCount().triangleNumber(nums));
    }
}
