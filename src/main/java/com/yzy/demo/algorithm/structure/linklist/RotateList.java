package com.yzy.demo.algorithm.structure.linklist;

/**
 * 右侧链表旋转到左侧
 * https://leetcode.cn/problems/rotate-list/
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * @author yangzyh
 * @date 2022/9/5 10:49
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 计算链表中节点个数
        int len = calculateLen(head);
        k = k%len;

        // 慢指针初始指向头节点
        ListNode slow = head;
        // 快指针初始指向头节点
        ListNode fast = head;

        // 快指针先向前移动k步
        for(int i = 0; i < k; i++) {
            fast= fast.next;
        }

        // 快慢指针同时向前移动，直到快指针指向的节点的
        // 下一个节点为null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 快指针此时在链表末尾
        // 然后其指向的节点的后继指针指向头节点
        // 这时链表首尾相连成环
        fast.next = head;
        // 新的头节点是慢指针所指节点的下一个节点
        head = slow.next;
        // 慢指针所指节点的的后继指针指向null
        // 断开环
        slow.next = null;
        return head;
    }

    private int calculateLen(ListNode head){
        int len = 0;
        while (head!=null) {
            head = head.next;
            len++;
        }
        return len;
    }

    //作者：hardcore-aryabhata
    //链接：https://leetcode.cn/problems/rotate-list/solution/dong-hua-yan-shi-kuai-man-zhi-zhen-61-xu-7bp0/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        ListNode result = new RotateList().rotateRight(node, 1);
    }
}
