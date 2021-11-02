package com.yzy.demo.algorithm.offer;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;

/**
 * 剑指offer 7
 * @author yangzyh
 * @date 2021/11/3 0:05
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==1 || inorder.length == 1) {
            return new TreeNode(-1);
        }
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeCore(preorder, inorder);
    }

    /**
     * 空间复杂度太高了
     * @param preorder
     * @param inorder
     * @return
     */
    private TreeNode buildTreeCore(int[] preorder, int[] inorder) {
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        if(preorder.length ==1) {
            if(inorder.length ==1 && preorder[0] == inorder[0]) {
                return root;
            } else {
                throw new IllegalArgumentException("invalid input");
            }
        }
        // 中序遍历中root元素的下标
        int rootInOrderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootValue) {
                rootInOrderIndex = i;
                break;
            }
        }
        if(inorder[rootInOrderIndex] != rootValue) {
            throw new IllegalArgumentException("invalid input..");
        }
        if(rootInOrderIndex > 0) {
            // 说明还有左子树
            // 构建左子树
            root.left = buildTreeCore(Arrays.copyOfRange(preorder, 1, rootInOrderIndex+1),
                    Arrays.copyOfRange(inorder, 0, rootInOrderIndex));
        }
        if(rootInOrderIndex < preorder.length-1) {
            //还有右子树
            //构建右子树
            root.right = buildTreeCore(Arrays.copyOfRange(preorder, rootInOrderIndex +1, preorder.length),
                    Arrays.copyOfRange(inorder, rootInOrderIndex +1, inorder.length));
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new BuildTree().buildTree(pre, in);
        System.out.println(root);
    }
}
