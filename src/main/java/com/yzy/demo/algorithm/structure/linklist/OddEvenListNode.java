package com.yzy.demo.algorithm.structure.linklist;

/**
 * LC 328
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * @author yangzyh
 * @date 2022/4/20 18:45
 */
public class OddEvenListNode {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
