package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 5
 * @author yangzyh
 * @date 2021/11/2 1:06
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        int length = s.length();
        int charIndex = 0;
        // 空间有点浪费，可以先遍历一遍字符串，统计空格数目，确定新字符串长度：旧长度 + 空格数*2
        char[] charOfs = new char[length*3];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                charOfs[charIndex++] = '%';
                charOfs[charIndex++] = '2';
                charOfs[charIndex++] = '0';
            } else {
                charOfs[charIndex++] = s.charAt(i);
            }
        }

        return  new String(charOfs, 0, charIndex);
    }
}
