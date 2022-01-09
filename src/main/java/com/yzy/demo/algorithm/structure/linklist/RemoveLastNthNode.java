package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author yangzyh
 * @date 2021/12/19 23:46
 */
public class RemoveLastNthNode {

    /**
     * awesome man~ you did it!
     * 也可以创建哑节点next指向头节点，就不用对头节点删除时进行特殊判断了
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            throw new IllegalArgumentException("illegal head");
        }
        ListNode pHead = head;
        int listNodeSize = 0;
        while (pHead!=null) {
            listNodeSize++;
            pHead = pHead.next;
        }
        if(n > listNodeSize || n < 1) {
            throw  new IllegalArgumentException("illegal range");
        }
        if (n == listNodeSize) {
            // 删除头元素
            return head.next;
        } else {
            ListNode pNodeBeforeRemove = head;
            int step = 0;
            int removePosition = listNodeSize - n;
            while (step!= removePosition-1) {
                step++;
                pNodeBeforeRemove = pNodeBeforeRemove.next;
            }
            ListNode removeNode = pNodeBeforeRemove.next;
            pNodeBeforeRemove.next = pNodeBeforeRemove.next.next;
            // 被删的node置空是对的，参看LinkedList
            removeNode = null;
            return  head;
        }
    }
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode result = new RemoveLastNthNode().removeNthFromEnd(node1, 2);
        System.out.println(result);
    }
}
