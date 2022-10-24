package com.yzy.demo.algorithm.structure.linklist;

import java.util.List;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author yangzyh
 * @date 2022/10/24 21:23
 */
public class FindMiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = 0;
        ListNode firstP = head;
        while (firstP != null) {
            size++;
            firstP = firstP.next;
        }
        int middle = size / 2;
        ListNode secondP = head;
        for (int i = 0; i < middle; i++) {
            secondP = secondP.next;
        }
        return secondP;
    }
}
