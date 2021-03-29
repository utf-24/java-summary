package com.yzy.demo.algorithm;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @author yangzyh
 * @date 2021/3/28 18:23
 */
public class RemoveLeastChar {
    private static String removeLeastChar(String words) {
        if(words == null || words.length() == 0) {
            return "";
        }
        //用来存储26个字母的出现次数
        int[] letterBucket = new int[26];
        for (int i = 0; i < words.length(); i++) {
            int ascIICode = words.charAt(i);
            int bucketLocation = ascIICode - 97;
            letterBucket[bucketLocation]++;
        }

        // 获取字母出现的最少次数
        int minCount = getMinCount(letterBucket);
        for (int i = 0; i < letterBucket.length; i++) {
            if(letterBucket[i] == minCount) {
                char minCountChar = (char) (i+ 97);
                // 从源字符串中删除出现次数最少的字母
                words = words.replace(String.valueOf(minCountChar), "");
            }
        }

        return words.equals("") ? "empty": words;
    }

    private static int getMinCount(int[] letterBucket) {
        int minCount = letterBucket[0];
        for (int i = 0; i < letterBucket.length; i++) {
            if(letterBucket[i] < minCount && letterBucket[i]!=0){
                minCount = letterBucket[i];
            } else if(minCount == 0) {
                minCount = letterBucket[i];
            }
        }

        return  minCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String words = scanner.nextLine();
            System.out.println(removeLeastChar(words));
        }
    }
}
