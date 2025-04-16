package com.yzy.demo.algorithm.structure.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc : https://leetcode.cn/problems/list-of-depth-lcci/description/
 *
 * DFS,深度遍历优先
 * @Author : yangzyh
 * @Date : 2025/4/16 18:55
 */
public class getListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> ans = new ArrayList<>();
        dfs(tree, 0, ans);
        return ans.toArray(new ListNode[0]);
    }


    private void dfs(TreeNode node, int level, List<ListNode> ans) {
        if (node == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ListNode(node.val));
        } else {
            ListNode head = new ListNode(node.val);
            //秒啊
            head.next = ans.get(level);
            ans.set(level, head);
        }
        // 一定是先右后左
        dfs(node.right, level + 1, ans);
        dfs(node.left, level + 1, ans);
    }
}
