package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/
 * 5, 2, 13, 3, 8
 *
 * @author yangzyh
 * @date 2023/2/9 21:32
 */
public class RemoveRightBiggerNodes {
    public ListNode removeNodes(ListNode head) {
        ListNode p = reversListNode(head);
        ListNode cur = p;
        while (cur.next != null) {
            if (cur.next.val < cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return reversListNode(p);
    }

    private ListNode reversListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(1, null));
        ListNode r = new RemoveRightBiggerNodes().removeNodes(a);
        System.out.println(r);
    }
}
