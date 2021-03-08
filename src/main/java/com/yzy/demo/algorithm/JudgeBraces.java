package com.yzy.demo.algorithm;

import org.apache.commons.lang.StringUtils;

import java.util.Scanner;
import java.util.Stack;

/**
 * 判断括号是否有效，左括号和右括号一一对应
 * e.g. (())
 * @author yangzyh
 * @date 2021/3/8 19:34
 */
public class JudgeBraces {

    public static boolean isValidUseStack(String s) {
        if(StringUtils.isBlank(s)) {
            return true;
        }
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }else if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        if(StringUtils.isBlank(s)) {
            return false;
        }
        if(s.length() % 2 ==1) {
            return false;
        }
        int leftBraceNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftBraceNumber++;
            }else if (c == ')') {
                if(leftBraceNumber <=0) {
                    return false;
                }
                leftBraceNumber--;
            }
        }

        return leftBraceNumber == 0;
    }

    public static void main(String[] args) {
        System.out.println("please enter test data(enter 'q' to quit):" );
        String quit = "";
        while(!quit.equals("q")) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            System.out.println("[isValidUseStack] " + isValidUseStack(line));
            System.out.println("[isValid] " + isValid(line));
            quit = line;
        }
    }
}
