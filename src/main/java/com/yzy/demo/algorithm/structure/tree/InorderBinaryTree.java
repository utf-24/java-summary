package com.yzy.demo.algorithm.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author yangzyh
 * @date 2022/1/11 23:03
 */
public class InorderBinaryTree {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doInorderTraversal(root, result);
        return result;
    }

    private void doInorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        doInorderTraversal(root.left, result);
        result.add(root.val);
        doInorderTraversal(root.right, result);
    }
}
