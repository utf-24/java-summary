package com.yzy.demo.algorithm;

/**
 * 剑指offer 43
 * 用21345测试
 * @author yangzyh
 * @date 2021/5/6 22:52
 */
public class NumberOf1 {

    public int countDigitOne(int n) {
        String strN = String.valueOf(n);
        if (strN.length() == 0) {
            return 0;
        }
        // 最高位的数
        int first = strN.charAt(0) - '0';
        if (strN.length() == 1 && first == 0) {
            return 0;
        }
        if (strN.length() == 1 && first > 0) {
            return 1;
        }
        double b = strN.length() - 1;
        double b2 = strN.length() - 2;
        // 统计1出现在最高位的情况
        int numOfFirstDigits;
        if (first == 1) {
            //入参数字最高位就是1, 如12345， 的到的就是 2345 +1
            numOfFirstDigits = Integer.parseInt(strN.substring(1)) + 1;
        } else {
            //入参数字最高位大于1, 无论是21345，还是31345，1在最高位的情况只有10000-19999，10^n-1
            numOfFirstDigits = (int) Math.pow(10d, b);
        }

        // 统计1出现在其他位的情况
        int numOfOtherDigits = (int) (first * (strN.length() - 1) * Math.pow(10d, b2));

        // 去除最高位后，递归相加
        return numOfFirstDigits + numOfOtherDigits + countDigitOne(Integer.parseInt(strN.substring(1)));
    }

    public static void main(String[] args) {
        NumberOf1 n = new NumberOf1();
        System.out.println(n.countDigitOne(1));
        System.out.println(n.countDigitOne(5));
        System.out.println(n.countDigitOne(10));
        System.out.println(n.countDigitOne(55));
        System.out.println(n.countDigitOne(99));
        System.out.println(n.countDigitOne(10000));
        System.out.println(n.countDigitOne(21345));
        System.out.println(n.countDigitOne(0));
    }
}
