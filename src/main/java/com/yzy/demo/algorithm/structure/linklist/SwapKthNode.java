package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/
 * @author yangzyh
 * @date 2023/1/1 21:50
 */
public class SwapKthNode {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstKthNode = head;
        for (int i = 1; i < k; i++) {
            firstKthNode = firstKthNode.next;
        }
        ListNode cur = firstKthNode;
        ListNode lastKthNode = head;
        while (cur.next != null) {
            cur = cur.next;
            lastKthNode = lastKthNode.next;
        }
        int tempValue = firstKthNode.val;
        firstKthNode.val = lastKthNode.val;
        lastKthNode.val = tempValue;

        return head;
    }


}
