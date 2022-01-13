package com.yzy.demo.algorithm.structure.tree;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author yangzyh
 * @date 2022/1/13 19:58
 */
public class BinaryTreeHeight {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
}
