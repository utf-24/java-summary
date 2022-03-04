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

    /**https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * 公式不好推导啊，快慢指针相遇后，新的指针从头开始，慢指针从相遇节点开始，最终在环入口相遇。
     * 找到环形链表的入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return  null;
        }
        ListNode quick = head;
        ListNode slow = head;
        while (quick !=null) {
            slow = slow.next;
            if (quick.next != null) {
                quick = quick.next.next;
            } else {
                return null;
            }
            if (quick == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }

        return null;
    }
}
