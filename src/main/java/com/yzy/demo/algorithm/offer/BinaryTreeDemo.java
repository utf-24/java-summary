package com.yzy.demo.algorithm.offer;

import javax.swing.tree.TreeNode;

/**
 * @author yangzyh
 * @date 2021/8/14 19:42
 */
public class BinaryTreeDemo {

    int leftDepth;
    int rightDepth;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 剑指offer 55 I 二叉树的深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public boolean isBalanced(TreeNode root) {

        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight,rightHeight) +1;
    }

}
