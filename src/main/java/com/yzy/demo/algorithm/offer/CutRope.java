package com.yzy.demo.algorithm.offer;


/**
 * offer 14
 * @author yangzyh
 * @date 2021/11/8 20:52
 */
public class CutRope {

    /**
     * 动态规划，推到出公式， f(n) = max(f(i) * f(n-i)) 0<i<n
     * 时间： O(n2)
     * 空间   O(n)
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int[] products = new int[n +1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max =0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if(max < product) {
                    max = product;
                }
                products[i] =max;
            }
        }

        return products[n];
    }

    /**
     * 贪婪算法：当n>=5 3(n-1)>= 2(n-1),
     *          当n=4时，2*2 >3*1
     *  时间：O(1)
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int timesOf3 = n/3;
        if(n-timesOf3*3 == 1) {
            timesOf3-=1;
        }
        int timesOf2 = (n-timesOf3*3)/2;

        return (int) (Math.pow(2,timesOf2) * Math.pow(3, timesOf3));
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().cuttingRope(8));
        System.out.println(new CutRope().cuttingRope(10));
    }
}
