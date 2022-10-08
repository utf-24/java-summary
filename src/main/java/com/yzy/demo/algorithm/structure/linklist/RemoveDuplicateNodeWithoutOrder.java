package com.yzy.demo.algorithm.structure.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/remove-duplicate-node-lcci/
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * @author yangzyh
 * @date 2022/10/8 21:58
 */
public class RemoveDuplicateNodeWithoutOrder {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode fakeHead = new ListNode(-1, head);
        ListNode p = fakeHead;
        Set<Integer> addedNodes = new HashSet<>();
        while (p.next != null) {
            if (addedNodes.add(p.next.val)) {
                p = p.next;
            } else {
                p.next = p.next.next;
            }
        }

        return  fakeHead.next;
    }
}
