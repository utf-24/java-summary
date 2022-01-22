package com.yzy.demo.algorithm.structure.tree;

/**
 * @author yangzyh
 * @date 2022/1/22 23:29
 */
public class ReverseBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        doInvertTree(root);
        return root;
    }

    private void doInvertTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        doInvertTree(root.right);
        doInvertTree(root.left);
    }
}
