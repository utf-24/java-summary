package com.yzy.demo.algorithm.offer;

import java.util.Arrays;

/**
 * @author yangzyh
 * @date 2021/8/15 10:55
 */
public class NumberAppearOnce {

    /**
     * 有两个数字只出现一次，其余数字出现两次
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        // 按位异或的结果
        int xorByBit = 0;
        for (int num : nums) {
            xorByBit ^= num;
        }
        // 从右边开始第几位的数字是1
        int indexOfBit1 = findIndexOfBit1(xorByBit);
        // 把数组按照异或结果分为两个子数组，每个子数组都包含一个只出现一次的数字
        int num1 =0, num2 = 0;
        for (int num : nums) {
            if (bitIs1(num, indexOfBit1)) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        int[] result = new int[2];
        result[0] = num1;
        result[1] = num2;

        return result;
    }

    /**
     * 判断指定的位数是否为1
     * @param num
     * @param indexOfBit1
     * @return
     */
    private boolean bitIs1(int num, int indexOfBit1) {
        num = num >> indexOfBit1;
        return ((num &1) == 0);
    }

    private int findIndexOfBit1(int xorByBit) {
        int bitOf1 = 0;
        while (((xorByBit & 1) == 0) && bitOf1 < 32) {
            xorByBit = xorByBit>>1;
            bitOf1++;
        }
        
        return bitOf1;
    }

    /**
     * 只有一个数字出现一次，其他数字出现三次
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] sumOfBits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >=0 ; j--) {
                int bit = nums[i] & bitMask;
                if(bit !=0)
                sumOfBits[j]+=1;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result<<=1;
            result += sumOfBits[i] %3;
        }

        return result;
    }
    public static void main(String[] args) {
        //int[] a = {4,1,4,6};
        //System.out.println(Arrays.toString(new NumberAppearOnce().singleNumbers(a)));
        int[] b = {1,1,1,2};
        System.out.println(new NumberAppearOnce().singleNumber(b));
    }
}
