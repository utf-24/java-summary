package com.yzy.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 1234
 *  567
 * 1801
 * @author yangzyh
 * @date 2021/5/10 20:36
 */
public class AddDemo {

    /**
     * 法1
     * @param str1
     * @param str2
     * @return
     */
    public String add(String str1, String str2) {
        if(str1 == null || str2 ==null) {
            return "0";
        }
        int lengthA = str1.length();
        int lengthB = str2.length();
        int minDigits = Math.min(lengthA, lengthB);
        int temp = 0;
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= minDigits; i++) {
            int result = Integer.parseInt(String.valueOf(str1.charAt(lengthA-i)))
                    + Integer.parseInt(String.valueOf(str2.charAt(lengthB - i))) + temp;
            if(result >= 10) {
                result = result%10;
                temp = 1;
            } else {
                temp =0;
            }
            results.add(result);
        }

        String moreDigitsStr = lengthA > lengthB?str1: str2;
        int moreDigits = moreDigitsStr.length() - minDigits;
        for (int i = moreDigits; i >0 ; i--) {
                int result = Integer.parseInt(String.valueOf(moreDigitsStr.charAt(i-1))) + temp;
                if(result == 10) {
                    temp = 1;
                    result = 0;
                } else {
                    temp = 0;
                }
                results.add(result);
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = results.size()-1; i >=0 ; i--) {
            resultBuilder.append(results.get(i));
        }
        return resultBuilder.toString();
    }


    /**
     * 法2
     * @param str1
     * @param str2
     * @return
     */
    public String addSimply(String str1, String str2) {
        return String.valueOf(Integer.parseInt(str1) + Integer.parseInt(str2));
    }

    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "567";
        System.out.println(new AddDemo().add(str1,str2));
        System.out.println(new AddDemo().addSimply(str1,str2));
    }
}
