package com.yzy.demo.algorithm.offer;

/**
 * offer 15
 * @author yangzyh
 * @date 2021/11/9 20:12
 */
public class CountOf1 {

    /**
     * （n-1）是把n表示的二进制的最右边的1改成0，后面所有位数都改成1，
     * 所以 n 和 n-1 按位与运算后，最右边的1变成0，左边的结果不变，二进制有多少个1，就可以这样操作多少次
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n = (n-1) & n;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountOf1().hammingWeight(12));
    }
}
