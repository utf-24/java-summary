package com.yzy.demo.algorithm;

/**
 * 剑指offer 44 求任意第n位对应的数字 e.g. 01234567..., input:7, output:7
 * 个位 0-9       10个数字 10位
 * 十位 10-99     90个数字  90*2 180位
 * 百位 100-999   900个数字 900*3 2700位
 * @author yangzyh
 * @date 2021/5/16 11:10
 */
public class DigitsInSequence {

    public int findNthDigit(int n) {
        if(n<0) {
            return -1;
        }
        // 默认数字是1位数
        int digits = 1;
        while (true) {
            //获取具体位数所在区间的数字个数
            long numbers = getCountOfDigits(digits);
            if(n < numbers*digits) {
                //n 小于当前位数的最大值
                return doFindNthDigit(n, digits);
            }
            // n大于当前位数，继续找下一位
            n-=numbers*digits;
            digits++;
        }
    }

    private int doFindNthDigit(int n, int digits) {
        long number = beginNumber(digits) + (long)n/digits;
        int digitsFromRight = digits - n%digits;

        for (int i =1 ; i< digitsFromRight; i++) {
            number /= 10;
        }
        return (int) (number%10);
    }

    //当前位数的第一个数
    private long beginNumber(int digits) {
        if(digits == 1) {
            return 0;
        }

        return (long) Math.pow(10, digits-1);
    }

    private long getCountOfDigits(int digits) {
        if(digits == 1) {
            return 10;
        }
        long count = (long) Math.pow(10, digits-1);
        return 9 * count;
    }

    public static void main(String[] args) {
        System.out.println(new DigitsInSequence().findNthDigit(1000000000));
    }
}
