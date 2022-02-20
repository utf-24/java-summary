package com.yzy.demo.algorithm.structure.tree;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author yangzyh
 * @date 2022/2/20 13:12
 */
public class FindBTDiameter {
    int diameter;

    public int findDiameter(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if(left + right > diameter) {
            diameter = left + right;
        }

        return Math.max(left, right) +1;
    }
}
