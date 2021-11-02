package com.yzy.demo.algorithm.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指offer 6
 * @author yangzyh
 * @date 2021/11/2 22:07
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class ReverseNode {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head!=null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
           result[i] = stack.pop();
        }
        return result;
    }
}
