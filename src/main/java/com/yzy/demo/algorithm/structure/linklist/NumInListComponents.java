package com.yzy.demo.algorithm.structure.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-components/solutions/1883654/lian-biao-zu-jian-by-leetcode-solution-5f91/
 * @author yangzyh
 * @date 2024/11/18 21:24
 */
public class NumInListComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        int result = 0;
        boolean inSet = false;
        while (head != null) {
            if (numSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    result++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return result;
    }
}
