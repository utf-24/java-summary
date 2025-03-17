package com.yzy.demo.algorithm.structure.linklist;

/**
 * @Desc :https://leetcode.cn/problems/linked-list-in-binary-tree/description/
 * @Author : yangzyh
 * @Date : 2025/3/17 19:45
 */
public class FindListNodeInTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
