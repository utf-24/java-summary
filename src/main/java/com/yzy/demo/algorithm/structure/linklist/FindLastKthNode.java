package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * @author yangzyh
 * @date 2022/11/16 22:01
 */
public class FindLastKthNode {
    public int kthToLast(ListNode head, int k) {
        ListNode pFirst = head;
        ListNode pSecond = head;
        for (int i = 0; i < k; i++) {
            pFirst = pFirst.next;
        }
        while (pFirst != null) {
            pFirst = pFirst. next;
            pSecond = pSecond.next;
        }

        return pSecond.val;
    }
}
