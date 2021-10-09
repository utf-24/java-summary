package com.yzy.demo.algorithm.offer;

import java.util.Arrays;

/**
 * 剑指offer 61 判断扑克牌顺子
 *
 * @author yangzyh
 * @date 2021/10/9 15:14
 */
public class PokerContinue {
    public boolean isStraight(int[] nums) {
        // 先对数组排序
        Arrays.sort(nums);
        // 大小王可以是任意数字，就当成0
        int numOf0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] ==0) {
                numOf0++;
            }
        }
        // 两个数字间差了几个数
        int numOfGap = 0;
        int small = numOf0;
        int big = small + 1;
        while (big < nums.length) {
            if (nums[small] == nums[big]) {
                // 出现了对子
                return false;
            }
            numOfGap += nums[big] - nums[small] - 1;
            small = big;
            big++;
        }

        return numOfGap <= numOf0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,12,0,3};
        System.out.println(new PokerContinue().isStraight(a));
    }
}
