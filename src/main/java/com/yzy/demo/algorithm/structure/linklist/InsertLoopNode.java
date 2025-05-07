package com.yzy.demo.algorithm.structure.linklist;

/**
 * @Desc :
 * @Author : yangzyh
 * @Date : 2025/5/7 18:57
 */
public class InsertLoopNode {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;
    }

    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/4ueAj6/solutions/1606890/pai-xu-de-xun-huan-lian-biao-by-leetcode-f566/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
