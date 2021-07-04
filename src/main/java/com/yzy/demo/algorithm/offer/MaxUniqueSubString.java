package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 48
 *
 * @author yangzyh
 * @date 2021/7/4 16:58
 */
public class MaxUniqueSubString {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int currentLength = 0;
        //记录每个字符上次出现的的下标，没出现为-1
        //int[] position = new int[26];
        // ascII码所有情况
        int[] position = new int[127];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int preIndex = position[c];
            if (preIndex < 0 || i - preIndex > currentLength) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = i - preIndex;
            }

            position[c] = i;
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MaxUniqueSubString().lengthOfLongestSubstring("arabcacfr"));
    }
}
