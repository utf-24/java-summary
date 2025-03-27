package com.yzy.demo.algorithm.structure.linklist;/**
  * @author yangzyh
  * @date 2025/3/25 19:17
  */
public class DoublingListNode {
    public ListNode doubleIt(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }

        for (ListNode cur = head; cur != null; cur = cur.next) {
            cur.val = cur.val * 2 % 10;
            if (cur.next!= null && cur.next.val >4) {
                cur.val++;
            }
        }
        return head;
    }
}
