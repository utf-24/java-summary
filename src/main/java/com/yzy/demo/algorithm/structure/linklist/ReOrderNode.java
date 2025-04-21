package com.yzy.demo.algorithm.structure.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc : https://leetcode.cn/problems/LGjMqU/description/?envType=problem-list-v2&envId=linked-list
 * @Author : yangzyh
 * @Date : 2025/4/21 19:09
 */
public class ReOrderNode {
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node !=null){
            list.add(node);
            node = node.next;
        }
        int i =0, j = list.size() - 1;
        while ( i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
