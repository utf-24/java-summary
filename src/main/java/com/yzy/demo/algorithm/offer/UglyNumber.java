package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 49
 *
 * @author yangzyh
 * @date 2021/7/7 23:53
 */
public class UglyNumber {
    public int findUglyNumber(int index) {
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyNumberIndex = 1;
        int i = 0, j = 0, k = 0;
        while (nextUglyNumberIndex < index) {
            int minUglyNumber = min(uglyNumbers[i] * 2, uglyNumbers[j] * 3, uglyNumbers[k] * 5);
            uglyNumbers[nextUglyNumberIndex] = minUglyNumber;

            while (uglyNumbers[i] * 2 <= uglyNumbers[nextUglyNumberIndex]) {
                i++;
            }
            while (uglyNumbers[j] * 3 <= uglyNumbers[nextUglyNumberIndex]) {
                j++;
            }
            while (uglyNumbers[k] * 5 <= uglyNumbers[nextUglyNumberIndex]) {
                k++;
            }
            ++nextUglyNumberIndex;
        }

        return uglyNumbers[nextUglyNumberIndex - 1];
    }

    private int min(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().findUglyNumber(10));
    }
}
