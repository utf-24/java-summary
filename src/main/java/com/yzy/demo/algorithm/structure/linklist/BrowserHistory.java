package com.yzy.demo.algorithm.structure.linklist;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/design-browser-history/description/
 */
class BrowserHistory {
    private Stack<String> s1 = new Stack<>();
    private Stack<String> s2 = new Stack<>();
    public BrowserHistory(String homepage) {
        s1.push(homepage);
    }
    
    public void visit(String url) {
        s1.push(url);
        s2.clear();
    }
    
    public String back(int steps) {
        // s1 第一个元素是homepage，所以判断条件是s1.size > 1
        for (int i = 0; i < steps && s1.size() > 1; i++) {
            s2.push(s1.pop());
        }
        return s1.peek();
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && !s2.isEmpty(); i++) {
            s1.push(s2.pop());
        }
        return s1.peek();
    }
}