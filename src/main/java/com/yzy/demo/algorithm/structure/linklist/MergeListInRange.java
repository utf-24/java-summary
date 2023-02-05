package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 *
 * @author yangzyh
 * @date 2023/2/5 22:18
 */
public class MergeListInRange {
    /**
     * 1 <= a <= b < list1.length - 1
     *
     * @param list1
     * @param a    a>=1, 但是下标从0开始
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyHead = new ListNode(-1, list1);
        ListNode prevA = dummyHead;
        for (int i = 0; i < a; i++) {
            prevA = prevA.next;
        }
        ListNode bNext = prevA.next;
        for (int i = a; i < b + 1; i++) {
            bNext = bNext.next;
        }
        prevA.next = list2;
        ListNode list2Tail = list2;
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }
        list2Tail.next = bNext;

        return list1;
    }
}
