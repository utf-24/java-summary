package com.yzy.demo.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 计算一个式子加上括号后而可能的最小值：
 * 输入：
 * 55-50+40
 * 输出：
 * -35
 * 解释：
 * 通过增加括号，该算式有两种可能的结果：55-50+40=45和55-(50+40)=-35
 *
 * @author young
 * @date 2019/9/29 21:22
 */
public class CalculationMin {
    static int getMinResult(String str) {
        int result = 0;
        /**
         * 是否有减号的标识
         */
        boolean hasSub = false;

        /**
         * 减号第一次出现的位置
         */
        int subIndex = 0;
        char[] array = str.toCharArray();
        for(char c : array) {
            // 确定第一个减法是第几次计算
            if(c == '+'){
                subIndex++;
            }else if(c == '-') {
                subIndex++;
                hasSub = true;
                break;
            }
        }
        String[] numbers = str.split("\\+|\\-");

        if(!hasSub) {
            // 没有减号，直接全加
            for(String numStr: numbers){
                result+=Integer.parseInt(numStr);
            }
        }else{
            for(int i = 0;i<numbers.length;i++){
                if(i<subIndex){
                    result+=Integer.parseInt(numbers[i]);
                }else {
                    // 开始计算第一个减号后的所有数的和
                    int subValue =0;
                    for(int j = i; j<numbers.length;j++){
                        subValue+=Integer.parseInt(numbers[j]);
                    }
                    result-=subValue;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        System.out.println(getMinResult(str));
    }
}
