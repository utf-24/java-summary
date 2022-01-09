package com.yzy.demo.algorithm.structure.linklist;

/**
 * @author yangzyh
 * @date 2021/12/23 0:12
 */
public class JudgeCycleNode {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick!=null && quick.next!=null) {
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow) {
                return true;
            }
        }

        return false;
    }
}
