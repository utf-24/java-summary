package com.yzy.demo.algorithm.offer;

/**
 * @author yangzyh
 * @date 2021/10/16 22:00
 */
public class SpecialAdd {

    /**
     * 剑指offer 64
     * @param n
     * @return
     */
    int addContinuous(int n) {
        boolean flag = n > 0 && (n += addContinuous(n - 1)) > 0;
        return n;
    }

    int add(int num1, int num2) {
        int sum=0;
        int carry =0;
        do {
            sum = num1 ^ num2;
            // carry为0就代表不用进位了
            carry = (num1 & num2)<<1;
            num1 = sum;
            num2 = carry;
        } while (num2!=0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SpecialAdd().addContinuous(3));
        System.out.println(new SpecialAdd().add(5,17));
    }
}
