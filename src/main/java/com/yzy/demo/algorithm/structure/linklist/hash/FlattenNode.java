package com.yzy.demo.algorithm.structure.linklist.hash;

/**
 * @author yangzyh
 * @date 2024/7/18 19:04
 */
public class FlattenNode {
    private class Node{
        int val;
        Node prev;
        Node next;
        Node child;
    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }



    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/solutions/1013884/bian-ping-hua-duo-ji-shuang-xiang-lian-b-383h/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
