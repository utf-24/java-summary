package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/insertion-sort-list/
 * 对链表进行插入排序,升序
 * e.g.  4,2,1,3
 * @author yangzyh
 * @date 2023/1/30 22:06
 */
public class InsertionSortListNode {
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummyHead;
                while (pre.next.val <= curr.val) {
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
