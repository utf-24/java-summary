package com.yzy.demo.algorithm.structure.linklist;

import java.util.List;

/**
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/?envType=problem-list-v2&envId=linked-list
 * @author yangzyh
 * @date 2025/1/20 18:53
 */
public class SortedList2TreeNode {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, Object right) {
        if (left == right) return null;
        ListNode mid = getMidVal(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);

        return root;
    }

    private ListNode getMidVal(ListNode left, Object right) {
        ListNode quick = left;
        ListNode slow = left;
        while (quick!= right && quick.next!= right) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
