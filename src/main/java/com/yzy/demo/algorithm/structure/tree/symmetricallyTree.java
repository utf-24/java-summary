package com.yzy.demo.algorithm.structure.tree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 中序遍历后判断root两边是否相等，不行！
 * @author yangzyh
 * @date 2022/1/12 19:55
 */
public class symmetricallyTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }

        return check(p.left, q.right) && check(p.right, q.left);
    }
}
