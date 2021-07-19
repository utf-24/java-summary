package com.yzy.demo.algorithm.linklist;

/**
 * 寻找两个链表的合并节点
 *
 * @author yangzyh
 * @date 2021/7/19 21:41
 */
public class FindMergeNode {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 怎么才能想到这么机智的办法。。。。。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
