package com.yzy.demo.algorithm.structure.linklist;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/palindrome-linked-list-lcci/
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * @author yangzyh
 * @date 2022/10/25 22:24
 */
public class JudgePalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode firstHalfEnd = findHalf(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        ListNode pFirst = head;
        ListNode pSecond = secondHalfStart;
        // 不用判断链表是偶数还是基数，如果是偶数，pFisrt 比pSecond多一个节点，pSecond为空后就不用再比较了
        while (pFirst != null && pSecond != null) {
            if (pFirst.val != pSecond.val) {
                return false;
            }
            pFirst = pFirst.next;
            pSecond = pSecond.next;
        }
        // 恢复链表
        firstHalfEnd.next = reverse(secondHalfStart);
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode now = node;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }

        return pre;
    }

    private ListNode findHalf(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        node.next = new ListNode(0, null);
        node.next.next = new ListNode(1, null);
        System.out.println(new JudgePalindrome().isPalindrome(node));
    }
}
