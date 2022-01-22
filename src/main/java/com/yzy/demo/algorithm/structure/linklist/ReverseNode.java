package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 * @author yangzyh
 * @date 2022/1/18 19:17
 */
public class ReverseNode {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pAddOne = cur.next;
        cur.next = null;
        while (pAddOne != null) {
            ListNode pAddTwo = pAddOne.next;
            pAddOne.next = cur;
            cur =pAddOne;
            pAddOne = pAddTwo;
        }

        return cur;
    }

    /**
     * 官网解法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
