package com.yzy.demo.algorithm.offer;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    // 存储中序遍历每个值所在的索引
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //if(preorder.length ==1 || inorder.length == 1) {
        //        //    return new TreeNode(-1);
        //        //}
        //        //if(preorder.length == 0 || inorder.length == 0) {
        //        //    return null;
        //        //}
        //        //return buildTreeCore(preorder, inorder);
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-by-leetcode-s/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param preorder
     * @param inorder
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
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
