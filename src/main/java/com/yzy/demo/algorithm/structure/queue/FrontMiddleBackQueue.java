package com.yzy.demo.algorithm.structure.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/design-front-middle-back-queue/description/
 *
 */
class FrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
    
    public void pushFront(int val) {
        left.addFirst(val);
        if (left.size() == right.size() +2){
            right.addFirst(left.pollLast());
        }
    }
    
    public void pushMiddle(int val) {
        if (left.size() == right.size() + 1){
            right.addFirst(left.pollLast());
        }
        left.addLast(val);
    }
    
    public void pushBack(int val) {
        right.addLast(val);
        if (left.size() + 1 ==right.size()) {
            left.addLast(right.pollFirst());
        }
    }
    
    public int popFront() {
        if (left.isEmpty()) return -1;
        int val= left.pollFirst();
        if (left.size() + 1 == right.size()) {
            left.addLast(right.pollFirst());
        }
        return val;
    }
    
    public int popMiddle() {
        if (left.isEmpty()) return -1;
        int val =left.pollLast();
        if (left.size() + 1 == right.size()) {
            left.addLast(right.pollFirst());
        }
        return val;
    }
    
    public int popBack() {
        if (left.isEmpty()) return -1;
        int val = 0;
        if (right.isEmpty()) {
            val = left.pollLast();
        } else {
            val = right.pollLast();
            if (left.size() == right.size() + 2) {
                right.addFirst(left.pollLast());
            }
        }
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */