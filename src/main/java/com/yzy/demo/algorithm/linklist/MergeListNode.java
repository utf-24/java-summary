package com.yzy.demo.algorithm.linklist;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/
 * @author yangzyh
 * @date 2021/12/2 0:47
 */
public class MergeListNode {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return doMerge(lists, 0 , lists.length-1);
    }

    private ListNode doMerge(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];
        if(left > right) return null;
        int mid = (left + right) >> 1;

        return mergeTwoLists(doMerge(lists, left, mid), doMerge(lists, mid+1, right));
    }
}
