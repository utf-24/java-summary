package com.yzy.demo.algorithm.structure.linklist;

/**
 * LC 92
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
