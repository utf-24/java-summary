package com.yzy.demo.algorithm.bit;

/**
 * https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
 * 时间：O（n）
 * 空间：O(1)
 * 异或运算是关键
 * @author yangzyh
 * @date 2022/1/3 14:01
 */
public class FindSingleNumber {
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num: nums) {
            singleNumber ^= num;
        }

        return singleNumber;
    }

    public static void main(String[] args) {
        System.out.println(new FindSingleNumber().singleNumber(new int[] {2,2,1}));
    }
}
