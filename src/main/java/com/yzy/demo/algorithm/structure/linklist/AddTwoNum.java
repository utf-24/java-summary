package com.yzy.demo.algorithm.structure.linklist;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/
 * @author yangzyh
 * @date 2023/2/7 20:50
 */
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Values = getNodeValues(l1);
        Stack<Integer> l2Values = getNodeValues(l2);
        ListNode next = null;
        int carry = 0;
        while (!l1Values.isEmpty() || !l2Values.isEmpty() || carry != 0) {
            int l1Value = l1Values.isEmpty() ? 0 : l1Values.pop();
            int l2Value = l2Values.isEmpty() ? 0 : l2Values.pop();
            int sum = l1Value + l2Value + carry;
            int value = sum % 10;
            carry = sum / 10;
            ListNode cur = new ListNode(value, next);
            next = cur;
        }
        return next;
    }

    private Stack<Integer> getNodeValues(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
