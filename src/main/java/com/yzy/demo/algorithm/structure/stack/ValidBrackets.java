package com.yzy.demo.algorithm.structure.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 输入：s = "{[]}"
 * 输出：true
 * @author yangzyh
 * @date 2022/1/9 10:20
 */
public class ValidBrackets {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> leftBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                leftBrackets.push(c);
            } else if ( c == ')' && !leftBrackets.isEmpty() && leftBrackets.peek() == '(') {
                leftBrackets.pop();
            } else if ( c == '}' && !leftBrackets.isEmpty() && leftBrackets.peek() == '{') {
                leftBrackets.pop();
            } else if ( c == ']' && !leftBrackets.isEmpty() && leftBrackets.peek() == '[') {
                leftBrackets.pop();
            } else {
                return false;
            }
        }

        return leftBrackets.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidBrackets().isValid("(())"));
    }
}
