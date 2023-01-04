package com.yzy.demo.algorithm.structure.linklist;

import org.checkerframework.checker.units.qual.min;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 *
 * @author yangzyh
 * @date 2023/1/4 22:52
 */
public class FindCriticalPointsDistance {

    /**
     * 最大距离是首尾极值点；
     * 最小距离一定是相邻的两个极值点
     * 时间 O(n)
     * 空间 O(1)
     * @param head
     * @return
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCriticalPoint = -1;
        int lastCriticalPoint = -1;
        int pos = 0;
        int minDistance = -1;
        int maxDistance = -1;
        ListNode cur = head;
        while (cur.next.next != null) {
            int left = cur.val;
            int mid = cur.next.val;
            int right = cur.next.next.val;
            if (mid > Math.max(left, right) || mid < Math.min(left, right)) {
                if (lastCriticalPoint != -1) {

                    minDistance = (minDistance == -1 ? pos - lastCriticalPoint :
                            Math.min(minDistance, pos - lastCriticalPoint));
                    maxDistance = Math.max(maxDistance, pos - firstCriticalPoint);
                }
                if (firstCriticalPoint == -1) {
                    firstCriticalPoint = pos;
                }
                lastCriticalPoint = pos;
            }
            cur = cur.next;
            pos++;
        }
        return new int[]{minDistance, maxDistance};
    }


    /**
     * 时间O(n)
     * 空间O(n)
     *
     * @param head
     * @return
     */
    public int[] nodesBetweenCriticalPoints2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        List<Integer> criticalPointsPositions = new ArrayList<>();
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        int position = 2;
        while (next != null) {
            if (IsCriticalPoint(cur, pre, next)) {
                criticalPointsPositions.add(position);
            }
            pre = cur;
            cur = next;
            next = next.next;
            position++;
        }
        if (criticalPointsPositions.size() < 2) {
            return new int[]{-1, -1};
        } else if (criticalPointsPositions.size() == 2) {
            int result = criticalPointsPositions.get(1) - criticalPointsPositions.get(0);
            return new int[]{result, result};
        } else {
            int max = criticalPointsPositions.get(criticalPointsPositions.size() - 1)
                    - criticalPointsPositions.get(0);
            int min = getMinDistance(criticalPointsPositions);
            return new int[]{min, max};
        }
    }

    private int getMinDistance(List<Integer> criticalPointsPositions) {
        int minDistance = criticalPointsPositions.get(1) - criticalPointsPositions.get(0);
        for (int i = 1; i < criticalPointsPositions.size() - 1; i++) {
            minDistance = Math.min(minDistance, criticalPointsPositions.get(i + 1) - criticalPointsPositions.get(i));
        }
        return minDistance;
    }

    /**
     * 判读cur节点是否是极值点
     *
     * @param cur
     * @param pre
     * @param next
     * @return
     */
    private boolean IsCriticalPoint(ListNode cur, ListNode pre, ListNode next) {
        return ((cur.val > pre.val && cur.val > next.val) ||
                (cur.val < pre.val && cur.val < next.val));
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5,
                new ListNode(3,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(1,
                                                        new ListNode(2, null)))))));

        int[] result = new FindCriticalPointsDistance().nodesBetweenCriticalPoints(head);
        System.out.println(result);
    }
}
