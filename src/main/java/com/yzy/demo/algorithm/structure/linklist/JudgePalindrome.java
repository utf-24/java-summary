package com.yzy.demo.algorithm.structure.linklist;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/palindrome-linked-list-lcci/
 * 编写一个函数，检查输入的链表是否是回文的。
 * @author yangzyh
 * @date 2022/10/25 22:24
 */
public class JudgePalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        boolean isEven = size % 2 == 0;
        ListNode slow = head;
        ListNode quick = head;
        Stack<Integer> firstHalfVal = new Stack<>();
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            firstHalfVal.push(slow.val);
            slow = slow.next;
        }
        if (!isEven) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != firstHalfVal.pop()) {
                return false;
            } else {
                slow = slow.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,null);
        node.next = new ListNode(0, null);
        node.next.next = new ListNode(1, null);
        System.out.println(new JudgePalindrome().isPalindrome(node));
    }
}
