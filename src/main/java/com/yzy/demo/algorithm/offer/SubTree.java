package com.yzy.demo.algorithm.offer;

/**
 * offer 26
 * @author yangzyh
 * @date 2021/11/11 20:52
 */
public class SubTree {
    /**
     * 判断B是否是A的子树
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if(A!=null && B!=null) {
            if(A.val == B.val) {
                result = doCheckSubTree(A,B);
            }
            if(!result) {
                result = isSubStructure(A.left, B);
            }
            if(!result) {
                result = isSubStructure(A.right, B);
            }
        }

        return result;
    }

    private boolean doCheckSubTree(TreeNode a, TreeNode b) {
        if(b == null) return true;
        if(a== null) return false;

        if(a.val !=b.val) return false;

        return  (doCheckSubTree(a.left, b.left) && doCheckSubTree(a.right, b.right));
    }
}
