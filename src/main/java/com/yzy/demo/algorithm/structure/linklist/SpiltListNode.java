package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/partition-list/
 * lc:86
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * @author yangzyh
 * @date 2022/4/16 0:08
 */
public class SpiltListNode {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode big = bigHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }


}
