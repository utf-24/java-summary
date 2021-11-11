package com.yzy.demo.algorithm.offer;

/**
 * offer 24
 * @author yangzyh
 * @date 2021/11/11 20:26
 */
public class ReverseListNode {
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode prevNode = null;
        while (curNode!=null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        return prevNode;
    }
}
