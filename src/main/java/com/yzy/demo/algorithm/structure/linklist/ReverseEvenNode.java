package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-even-length-groups/description/?envType=problem-list-v2&envId=linked-list
 * @author yangzyh
 * @date 2025/3/5 19:00
 */
public class ReverseEvenNode {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int i = 0;
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            i++;
            ListNode it = cur;
            int length = 0;
            // 计算当前组的长度
            while (length < i && it != null) {
                length++;
                it = it.next;
            }

            if ((length & 1) == 1) {
                // 如果当前组长度为奇数，直接移动指针
                for (int j = 0; j < length; j++) {
                    pre = cur;
                    cur = cur.next;
                }
            } else {
                // 如果当前组长度为偶数，反转该组节点
                for (int j = 0; j < length - 1; j++) {
                    ListNode temp = cur.next;
                    cur.next = temp.next;
                    temp.next = pre.next;
                    pre.next = temp;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        ListNode result = new ReverseEvenNode().reverseEvenLengthGroups(a);
        System.out.println(result);
    }
}
