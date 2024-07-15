package com.yzy.demo.algorithm.structure.linklist;
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * https://leetcode.cn/problems/binode-lcci/description/
 * key: 中序遍历
 * @author yangzyh
 * @date 2024/7/15 21:24
 */
public class TransferBiNode {
    TreeNode head = new TreeNode(-1);
    TreeNode prev = null;

    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev == null) {
            //first node
            head.right = root;
        } else {
            prev.right = root;
        }
        prev = root;
        root.left = null;
        helper(root.right);
    }
}
