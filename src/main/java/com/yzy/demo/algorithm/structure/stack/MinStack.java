package com.yzy.demo.algorithm.structure.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * @author yangzyh
 * @date 2022/1/15 15:43
 */
public class MinStack {
    private Stack<Integer> stack;
    // 储存每次入栈时的最小元素
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack =new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
