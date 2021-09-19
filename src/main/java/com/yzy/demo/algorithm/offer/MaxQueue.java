package com.yzy.demo.algorithm.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer 59II
 * @author yangzyh
 * @date 2021/9/19 16:27
 */
public class MaxQueue {

    private Queue<Integer> mainQueue;
    // 辅助队列，单调递减
    private Deque<Integer> descQueue;

    public MaxQueue() {
        mainQueue = new LinkedList<Integer>();
        descQueue = new LinkedList<Integer>();
    }

    public int max_value() {
        if(descQueue.isEmpty()) return -1;
        return descQueue.peekFirst();
    }

    public void push_back(int value) {
        while (!descQueue.isEmpty() && descQueue.peekLast() < value) {
            descQueue.pollLast();
        }
        descQueue.offerLast(value);
        mainQueue.offer(value);
    }

    public int pop_front() {
        if(mainQueue.isEmpty()) return -1;
        int front = mainQueue.poll();
        if(descQueue.peekFirst() == front) {
            descQueue.pollFirst();
        }

        return front;
    }
}
