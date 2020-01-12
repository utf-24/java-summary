package com.yzy.demo.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 输出斐波那契数列结果的后六位
 * @author young
 * @date 2019/9/29 20:03
 */
public class FibTest {

    static BigInteger fib(int n) {
        if (n < 3) {
            return new BigInteger("1");
        }
        BigInteger result = new BigInteger("0");
        BigInteger lastOne = new BigInteger("1");
        BigInteger lastTwo = new BigInteger("1");
        for(int i = 3; i<=n ;i++){
            result = lastOne.add(lastTwo);
            lastTwo = lastOne;
            lastOne = result;
        }
        return result;
    }

    /**
     * @param n fib param
     * @return  last six figures of the result
     */
    static int getLast6Figures(int n) {
        BigInteger result = fib(n);
        String s = result.toString();
        int sLength = s.length();
        if(sLength <=6) {
            return Integer.parseInt(s);
        }

            return Integer.parseInt(s.substring(sLength-6,sLength));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());
        System.out.println(getLast6Figures(num));
    }
}
