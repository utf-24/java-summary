package com.yzy.demo.algorithm.bit;


/**
 * https://leetcode-cn.com/problems/hamming-distance/submissions/
 * 求两个数 二进制表示中不同的个数
 * 先异或的到十进制结果，然后统计该数二进制表示中1的个数
 * @author yangzyh
 * @date 2022/2/15 18:42
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while (result > 0) {
            if ((result & 1) == 1) {
                count++;
            }
            result = result >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }
}
