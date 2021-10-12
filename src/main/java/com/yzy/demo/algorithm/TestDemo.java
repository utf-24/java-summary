package com.yzy.demo.algorithm;

import java.util.*;

/**
 * 给定一个字符串，找到第一个不重复的字符，返回。如果没有就返回空格；
 * @author yangzyh
 * @date 2021/10/12 19:40
 */
public class TestDemo {

    public char findFirstUniqueStr(String source) {
        Set<Character> result = new LinkedHashSet<>();
        Set<Character> needDeleteChars = new HashSet<>();
        char[] sourceOfChar = source.toCharArray();
        for (int i = 0; i < sourceOfChar.length; i++) {
            boolean addSuccess = result.add(sourceOfChar[i]);
            if(!addSuccess) {
                needDeleteChars.add(sourceOfChar[i]);
            }
        }

        result.removeAll(needDeleteChars);
        return result.isEmpty()? ' ': result.iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(new TestDemo().findFirstUniqueStr("aadadaad"));
    }
}
