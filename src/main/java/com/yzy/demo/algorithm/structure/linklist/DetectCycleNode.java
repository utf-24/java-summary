package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/linked-list-cycle-lcci/
 * @author yangzyh
 * @date 2023/2/28 22:24
 */
public class DetectCycleNode {

    /**
     * 找到环路入口节点，如果不存在返回null
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}
