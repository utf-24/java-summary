package com.yzy.demo.algorithm.structure.linklist;

/**
 * 链表排序，时间nlogn， 空间 O(1)
 * https://leetcode.cn/problems/sort-list/
 * @author yangzyh
 * @date 2023/2/21 11:13
 */
public class SortLinkNode {
    public ListNode sortListNode(ListNode head) {
        int length = getLength(head);
        ListNode dummyHead = new ListNode(-1, head);
        // 对并排序，自底向上
        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode curr = dummyHead.next;
            ListNode prev = dummyHead;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                //当前子数组的next都设成空，方便后续根据两个头节点的merge
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 下一个分组的开头元素
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    //当前子数组的next都设成空
                    curr.next = null;
                }
                prev.next = mergeNode(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    private ListNode mergeNode(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }

        return dummyHead.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3,new ListNode(4, new ListNode(1, new ListNode(2))));
        ListNode result = new SortLinkNode().sortListNode(head);
        System.out.println(result);
    }

}
