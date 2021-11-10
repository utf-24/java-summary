package com.yzy.demo.algorithm.offer;

/**
 * offer 22
 * @author yangzyh
 * @date 2021/11/10 20:56
 */
public class BackWardsKNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode result;
        int n= 0;

        if(k == 0) return null;

        for(result = head; result!=null; result = result.next) {
            n++;
        }
        if(k > n) return null;
        for(result = head; n > k; n--) {
            result = result.next;
        }

        return result;
    }
}
