package com.yzy.demo.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 判断一个数是否是2的n次幂
 * @author young
 * @date 2019/9/29 21:07
 */
public class ValidatePower {

    /**
     *  judge if the num is integer power of 2
     * @param n input num
     * @return result
     */
    static int judgePower(int n) {
        int result = 0;
        for(int i =1; i< 32;i++){
            if(2<<i == n){
                result =1;
                break;
            }
        }

        return result;
    }

    /**
     *  judge if the num is integer power of 2
     * @param n input num
     * @return result
     */
    static int judgePowerRecursive(int n, int bit) {
        if(bit >= 32) {
            return 0;
        }else if(2<<bit == n){
            return 1;
        }else {
            return judgePowerRecursive(n,++bit);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());
        System.out.println(judgePowerRecursive(num,0));
    }
}
