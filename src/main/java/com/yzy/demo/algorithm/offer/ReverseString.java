package com.yzy.demo.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指offer 58
 *
 * @author yangzyh
 * @date 2021/8/27 20:49
 */
public class ReverseString {

    /**
     * I 书上的解法，变态的测试用例过不了
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        int begin = 0, end = s.length()-1;
        //char[] chars = s.toCharArray();
        StringBuilder chars = new StringBuilder(s);
        doReverse(chars, begin, end);
        end = begin;
        while (end < s.length()) {
            if(chars.charAt(begin) == ' ') {
                begin++;
                end++;
            } else if(chars.charAt(end) == ' ' || end == s.length()-1) {
                doReverse(chars, begin, end-1);
                begin = ++end;
            } else {
                end++;
            }
        }

        return chars.toString();
    }

    /**
     * I 聪明的做法
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }


    private void doReverse(StringBuilder src, int begin, int end) {
        while (begin < end) {
            if (src.charAt(begin) != ' ' || src.charAt(end) != ' ') {
                char temp = src.charAt(begin);
                src.setCharAt(begin,src.charAt(end));
                src.setCharAt(end, temp);
            }
            begin++;
            end--;
        }
    }

    /**
     * II 左旋转字符串
     * e.g. abcdefg, 2,  cdefgab;
     * @param s
     * @param position
     * @return
     */
    private String leftReverse(String s, int position) {
        String str = s.substring(position);
        String result = str + s.substring(0,position);

        return result;
    };

    public static void main(String[] args) {
        //String s = "a good   example";
        //String s = "   a   b  c d   e  ";
        //System.out.println(new ReverseString().reverseWords(s));
        System.out.println(new ReverseString().leftReverse("abcdefg", 2));
    }
}
