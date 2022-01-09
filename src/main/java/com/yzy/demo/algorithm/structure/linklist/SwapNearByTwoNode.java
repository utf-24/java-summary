package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/
 * @author yangzyh
 * @date 2021/11/28 10:31
 */
public class SwapNearByTwoNode {
    /**
     * 时间 O(n)
     * 空间 O(1)
     * @param head
     * @return
     */
    public ListNode swapTwoNode(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next!=null && temp.next.next!=null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dummyHead.next;
    }
}
