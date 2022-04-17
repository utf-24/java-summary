package com.yzy.demo.algorithm.structure.linklist;

/**
 * LC 138
 * @author yangzyh
 * @date 2022/4/17 23:44
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyRandomListNode {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node;
        // 1，新创建所有的新节点，存在旧节点之后
        for (node = head;  node !=null ; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        // 2, 设置新节点的random，是旧节点random之后的节点
        for (node = head; node!=null; node = node.next.next) {
            Node newNode = node.next;
            newNode.random = (node.random == null) ? null: node.random.next;
        }
        // 3,重新分配新旧节点的next关系
        Node newHead = head.next;
        for (node = head; node!=null; node = node.next) {
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = (newNode.next == null)? null: newNode.next.next;
        }

        return newHead;
    }
}
