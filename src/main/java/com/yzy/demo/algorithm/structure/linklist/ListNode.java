package com.yzy.demo.algorithm.structure.linklist;

import com.yzy.demo.algorithm.structure.SpiralMatrix;

/**
 * 单链表
 * @author yangzyh
 * @date 2021/4/12 21:10
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
