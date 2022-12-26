package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/split-linked-list-in-parts/
 *
 * @author yangzyh
 * @date 2022/12/26 22:45
 */
public class SpiltListToKParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getListNodeSize(head);
        int quotient = size / k;
        int reminder = size % k;
        ListNode cur = head;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k && cur != null; i++) {
            result[i] = cur;
            //比如 11/3   前两组partSize 都要是 3 + 1
            int partSize = quotient + (i < reminder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return result;
    }

    private int getListNodeSize(ListNode head) {
        int size = 0;
        ListNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }
}
