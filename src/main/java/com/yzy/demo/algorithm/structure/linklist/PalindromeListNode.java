package com.yzy.demo.algorithm.structure.linklist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author yangzyh
 * @date 2022/1/26 12:53
 */
public class PalindromeListNode {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        // 只比较一半就可以了，可以优化
        while (head != null) {
            int val = stack.pop();
            if(val != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
