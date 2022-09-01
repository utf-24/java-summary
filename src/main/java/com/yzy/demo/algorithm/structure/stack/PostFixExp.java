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
    }
}
