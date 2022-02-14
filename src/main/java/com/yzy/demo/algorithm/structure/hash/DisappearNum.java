package com.yzy.demo.algorithm.structure.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
 * @author yangzyh
 * @date 2022/2/14 18:26
 */
public class DisappearNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new DisappearNum().findDisappearedNumbers(new int[]{1,1,2,1}));
    }
}
