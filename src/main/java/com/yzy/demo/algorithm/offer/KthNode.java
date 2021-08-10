package com.yzy.demo.algorithm.offer;

import com.yzy.demo.algorithm.structure.TreeNode;

import java.util.TreeMap;

/**
 * 剑指offer 54
 * 找第k小的节点，中序遍历刚好是自增的顺序，左中右，
 *如果是第k大的节点，应该 右中左遍历
 * @author yangzyh
 * @date 2021/8/10 21:26
 */
public class KthNode {

    int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        findKthLargestCore(root);
        return result;
    }

    private void findKthLargestCore(TreeNode root){
        if(root == null) return;
        findKthLargestCore(root.right);
        if(k == 0) return;
        if(--k == 0) result = root.val;
        findKthLargestCore(root.left);
    }
}
