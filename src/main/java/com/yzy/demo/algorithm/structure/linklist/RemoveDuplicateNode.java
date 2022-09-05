package com.yzy.demo.algorithm.structure.linklist;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * @author yangzyh
 * @date 2022/9/5 14:17
 */
public class RemoveDuplicateNode {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1, head);
        ListNode cur = head;
        ListNode after = head.next;
        ListNode sentinel = pre;
        while (after !=null) {
            if (cur.val != after.val) {
                pre = cur;
            } else {
                while (after !=null && cur.val == after.val) {
                    after = after.next;
                }
                pre.next = after;
            }
            cur = after;
            if (after != null) {
                after = after.next;
            }
        }
        return  sentinel.next;
    }

    /**
     * 官方答案
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;

        //作者：LeetCode-Solution
        //链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-oayn/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public static void main(String[] args) {
        //ListNode n1 = new ListNode(1,
        //        new ListNode(2,
        //                new ListNode(3,
        //                        new ListNode(3,
        //                                new ListNode(4,
        //                                        new ListNode(4,
        //                                                new ListNode(5, null)))))));
        ListNode n1 = new ListNode(1,new ListNode(1,null));

        ListNode result = new RemoveDuplicateNode().deleteDuplicates(n1);
        System.out.println(result);
    }
}
