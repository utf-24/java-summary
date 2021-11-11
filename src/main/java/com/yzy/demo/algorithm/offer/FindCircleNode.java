package com.yzy.demo.algorithm.offer;

/**
 * offer 23
 *
 * @author yangzyh
 * @date 2021/11/11 9:46
 */
public class FindCircleNode {
    public ListNode getIntersectionNode(ListNode head) {
        ListNode meetingNode = getMeetingNode(head);
        if (meetingNode == null) return null;

        // 环内链表数目
        int circleNodeCount = 1;
        ListNode meetingNodeNext = meetingNode.next;
        while (meetingNode != meetingNodeNext) {
            circleNodeCount++;
            meetingNodeNext = meetingNodeNext.next;
        }
        ListNode quickNode = head;
        for (int i = 0; i < circleNodeCount; i++) {
            quickNode = quickNode.next;
        }
        ListNode slowNode = head;
        while (quickNode != slowNode) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }

        return quickNode;
    }

    private ListNode getMeetingNode(ListNode headA) {
        if (headA == null) return null;
        ListNode slowNode = headA.next;
        ListNode quickNode = slowNode.next;
        while (quickNode != null && slowNode != null) {
            if (quickNode == slowNode) {
                return quickNode;
            }
            slowNode = slowNode.next;
            quickNode = quickNode.next;
        }

        return null;
    }

    /**
     * https://leetcode-cn.com/problems/3u1WK4/
     * 时间O(n)
     * 空间O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
