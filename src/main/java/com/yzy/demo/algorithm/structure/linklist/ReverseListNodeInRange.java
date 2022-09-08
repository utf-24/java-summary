package com.yzy.demo.algorithm.structure.linklist;

/**
 * LC 92
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * @author yangzyh
 * @date 2022/4/16 1:06
 */
public class ReverseListNodeInRange {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre =dummyHead;
        for (int i = 0; i < left -1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < (right - left); i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyHead.next;
    }
}
