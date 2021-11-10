package com.yzy.demo.algorithm.offer;

/**
 * offer 18
 * @author yangzyh
 * @date 2021/11/9 23:22
 */

public class DeleteListNode {
    /**
     * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
     * 链表元素不重复, 时间O(n)
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode resultHead = head;
        if(head.val == val) {
            // 要删除的元素是第一个
            resultHead = head.next;
            head.next = null;
            return  resultHead;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        while (cur!=null) {
            if(cur.val == val) {
                prev.next = cur.next;
                return resultHead;
            }
            prev = cur;
            cur = cur.next;
        }

        return resultHead;
    }

    /**
     * 官方答案
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNodeOfficial(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur!=null && cur.val!=val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur!=null) {
            pre.next = cur.next;
        }
        return head;
    }

    /**
     * 时间 O(1)
     * @param head
     * @param target
     * @return
     */
    public ListNode deleteNode(ListNode head, ListNode target) {
        ListNode originHead = head;
        if(target == null) {
            return null;
        }
        if(head == target) {
            // 只有一个元素
            return null;
        }
        if(target.next == null) {
            // 要删的是最后一个元素
            while (head.next!=target) {
                head = head.next;
            }
            head.next = null;
        } else {
            //要删的不是最后一个元素
            target.val = target.next.val;
            target.next = target.next.next;
        }
        return originHead;
    }
}
