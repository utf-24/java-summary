package com.yzy.demo.algorithm.structure.linklist;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Desc :https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array/description/
 * @Author : yangzyh
 * @Date : 2025/3/27 19:09
 */
public class removeItemInArray {

    public ListNode removeItem(int [] nums, ListNode head) {
        if(nums.length == 0) return head;
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (numSet.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
     }
}
