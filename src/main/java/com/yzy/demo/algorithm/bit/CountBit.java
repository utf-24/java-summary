package com.yzy.demo.algorithm.bit;

/**
 * https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
 * @author yangzyh
 * @date 2022/2/13 21:33
 */
public class CountBit {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                // 是2的n次幂
                highBit = i;
            }
            // e.g. 13: 1101, 5:0101; so bits[13] = bits[13 - 8] + 1 = 3;
            // 多出的8其实就是多了个最高位的1
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(new CountBit().countBits(5));
    }
}
