package com.yzy.demo.algorithm.sort;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 时间：O(n)
 * 空间：O(n)
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author yangzyh
 * @date 2021/12/29 0:27
 */
public class FindLongestConsecutiveNums {

    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new LinkedHashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        int longestStep = 1;

        for (int num: numSet) {
            if(numSet.contains(num -1)) {
                continue;
            }
            int currentStep = 1;
            int currentNum = num;
            while (numSet.contains(currentNum +1)) {
                currentNum = currentNum + 1;
                currentStep++;
            }
            longestStep = Math.max(currentStep, longestStep);
        }

        return longestStep;
    }

    public static void main(String[] args) {
        System.out.println(new FindLongestConsecutiveNums().longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
