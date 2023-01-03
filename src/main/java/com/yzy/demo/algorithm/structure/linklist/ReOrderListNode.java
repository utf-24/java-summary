package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
 *  将后半个链表反转，然后和前半个链表交替合并，最优；
 *   1.找到链表的中点；
 *   2.翻转后半个链表
 *   3.将两个链表交替合并
 * @author yangzyh
 * @date 2023/1/3 22:46
 */
public class ReOrderListNode {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        // 后半个链表翻转
        right = reverseList(right);
        // 将两个链表交替合并
        mergeList(left, right);

    }

    private void mergeList(ListNode left, ListNode right) {
        ListNode leftTemp, rightTemp;
        while (left != null && right != null) {
            leftTemp = left.next;
            left.next = right;
            left = leftTemp;

            rightTemp = right.next;
            right.next = left;
            right = rightTemp;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}

