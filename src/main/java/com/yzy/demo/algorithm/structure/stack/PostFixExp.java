package com.yzy.demo.algorithm.structure.stack;

import java.util.Stack;

/**
 * 后缀表达式
 * e.g.  a + b * c + ( d * e + f ) * g
 *       a b c * + d e * f + g * +.
 * @author yangzyh
 * @date 2022/9/1 18:42
 */
public class PostFixExp {
    public  String convertToPostFixExp(String input) {
        char[] inputArray = input.toCharArray();
        Stack<Character> operatorStack = new Stack<>();
        Stack<Character> outputStack = new Stack<>();
        for (Character c: inputArray) {
            if (!isOperator(c)) {
                outputStack.push(c);
            } else {
                if(shouldPush(c, operatorStack)) {
                    operatorStack.push(c);
                } else if (c.equals(')')) {
                    while (operatorStack.peek() !='(') {
                        outputStack.push(operatorStack.pop());
                    }
                    operatorStack.pop();
                } else {
                    while (!operatorStack.isEmpty() &&
                            (isMultiplyOrDivision(operatorStack.peek()) || isAddOrSub(operatorStack.peek()))) {
                        outputStack.push(operatorStack.pop());
                    }
                    operatorStack.push(c);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            outputStack.push(operatorStack.pop());
        }

        return outputStack.toString();
    }

    /**
     * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> tempStack = new Stack<>();
        for (String s: tokens) {
            if (isOperator(s)) {
                // assume expression is legal, so before pop,tempStack must have num elements
                String numRight = tempStack.pop();
                String numLeft = tempStack.pop();
                String result = calculate(numLeft, numRight, s);
                tempStack.push(result);
            } else {
                tempStack.push(s);
            }
        }
        return Integer.parseInt(tempStack.pop());
    }

    private String calculate(String numLeft, String numRight, String operator) {
        int intNumLeft = Integer.parseInt(numLeft);
        int intNumRight = Integer.parseInt(numRight);
        int result;
        switch(operator) {
            case "+":
                result = intNumLeft + intNumRight;
                break;
            case "-":
                result = intNumLeft - intNumRight;
                break;
            case "*":
                result = intNumLeft * intNumRight;
                break;
            case "/":
                result = intNumLeft / intNumRight;
                break;
            default:
                result = 0;
                //throw new IllegalArgumentException("illegal operator " + operator);
        }
        return String.valueOf(result);
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    /**
     * judge whether it should push c into operatorStack or not.
     * such case should not push:
     * when c is ')'.
     * when c is + or - and operatorStack.top is * or /
     *
     * @param c
     * @param operatorStack
     * @return
     */
    private boolean shouldPush(Character c, Stack<Character> operatorStack) {
        if (operatorStack.isEmpty()) {
            return true;
        } else if (isAddOrSub(c) && isMultiplyOrDivision(operatorStack.peek())) {
            return false;
        } else return !c.equals(')');
    }

    private boolean isOperator(Character c) {
        return (isAddOrSub(c) || isMultiplyOrDivision(c) || isBrace(c));
    }

    private boolean isBrace(Character c) {
        return c.equals('(') || c.equals(')');
    }

    private boolean isAddOrSub(Character c) {
        return c.equals('+') || c.equals('-');
    }

    private boolean isMultiplyOrDivision(Character c) {
        return c.equals('*') || c.equals('/');
    }

    public static void main(String[] args) {
        System.out.println(new PostFixExp().convertToPostFixExp("a+b*c+(d*e+f)*g"));
        System.out.println(new PostFixExp().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
