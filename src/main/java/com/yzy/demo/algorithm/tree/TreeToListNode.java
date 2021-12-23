package com.yzy.demo.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开成单链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @author yangzyh
 * @date 2021/12/23 23:55
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class TreeToListNode {
    public void flatten(TreeNode root) {
        List<TreeNode> prevOrderNodes = new ArrayList<>();
        // 前序遍历
        prevOrderTreeNode(root, prevOrderNodes);
        int size = prevOrderNodes.size();
        for(int i = 1; i< size; i++) {
            TreeNode pre = prevOrderNodes.get(i-1);
            pre.left = null;
            pre.right = prevOrderNodes.get(i);
        }
    }

    private void prevOrderTreeNode(TreeNode root, List<TreeNode> prevOrderNodes) {
        if(root!=null) {
            prevOrderNodes.add(root);
            prevOrderTreeNode(root.left, prevOrderNodes);
            prevOrderTreeNode(root.right, prevOrderNodes);
        }
    }
}
