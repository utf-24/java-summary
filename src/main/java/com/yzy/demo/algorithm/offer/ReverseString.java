package com.yzy.demo.algorithm.offer;

import java.util.Arrays;

/**
 * 剑指offer 58
 *
 * @author yangzyh
 * @date 2021/8/27 20:49
 */
public class ReverseString {

    public String reverseWords(String s) {
        int begin = 0, end = s.length()-1;
        char[] chars = s.toCharArray();
        doReverse(chars, begin, end);
        end = begin;
        while (end < s.length()) {
            if(chars[end]!=' ' && end != s.length()-1) {
                end++;
            } else if(chars[end] == ' ') {
                doReverse(chars, begin, end-1);
                end++;
                begin = end;
            } else {
                doReverse(chars, begin, end);
                end++;
            }
        }
        return Arrays.toString(chars);
    }

    private void doReverse(char[] src, int begin, int end) {
        while (begin < end) {
            if (src[begin] != ' ' || src[end] != ' ') {
                char temp = src[begin];
                src[begin] = src[end];
                src[end] = temp;
            }
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new ReverseString().reverseWords(s));
    }
}
