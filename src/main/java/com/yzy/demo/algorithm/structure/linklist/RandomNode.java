package com.yzy.demo.algorithm.structure.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 返回链表的随机节点
 * https://leetcode.cn/problems/linked-list-random-node/
 * @author yangzyh
 * @date 2023/1/31 22:51
 */
public class RandomNode {
    private List<Integer> nodeValues = new ArrayList<>();
    private Random random;
    public RandomNode(ListNode head) {
        while (head != null) {
            nodeValues.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return nodeValues.get(random.nextInt(nodeValues.size()));
    }
}
