package com.yzy.demo.algorithm;

import java.util.Arrays;

/**
 * 反转字符串
 *
 * @author young
 * @date 2020/2/24 20:47
 */
public class ReverseStringDemo {
    static String reverse(String src) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] result = src.split(" ");
        for(int i = result.length-1; i>= 0; i--) {
            stringBuilder.append(result[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     *     此方法不对，单词不能改变顺序
     * @param src
     * @return
     */
    static String reverse2(String src) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = src.toCharArray();
        for(int i=charArray.length-1; i>=0; i--){
            stringBuilder.append(charArray[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String src = "I am a Cogenter";
        System.out.println(reverse(src));
        System.out.println(reverse2(src));
    }
}
