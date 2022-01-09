package com.yzy.demo.algorithm.structure.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author yangzyh
 * @date 2021/11/30 0:19
 */
public class TwoNumSum {
    public int[] twoNum(int[] nums, int target) {
        if(nums.length < 2) {
            throw new IllegalArgumentException("invalid array");
        }
        // 存储target -i 的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoNumSum().twoNum(new int[]{1, 4, 5}, 6)));
    }

}
