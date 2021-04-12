package com.yzy.demo.datastructure.list;

import java.util.Stack;

/**
 * 反转链表
 * @author yangzyh
 * @date 2021/4/12 21:14
 */
public class ReverseNodeDemo {

    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack();
        while (head!= null) {
            stack.push(head);
            head = head.next;
        }
        ListNode reverseHead = stack.pop();
        ListNode curNode = reverseHead;
        while (!stack.empty()) {
            curNode.next = stack.pop();
            curNode = curNode.next;
        }
        // 防止链表首尾连成环
        curNode.next = null;
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next =b;
        b.next = c;
        ListNode reverseHead = new ReverseNodeDemo().reverseList(a);
        while(reverseHead!=null) {
            System.out.print(reverseHead.val);
            System.out.print(" ");
            reverseHead = reverseHead.next;
        }
    }
}
