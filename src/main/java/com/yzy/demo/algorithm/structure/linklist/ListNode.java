package com.yzy.demo.algorithm.structure.linklist;

/**
 * 单链表
 * @author yangzyh
 * @date 2021/4/12 21:10
 */
public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
