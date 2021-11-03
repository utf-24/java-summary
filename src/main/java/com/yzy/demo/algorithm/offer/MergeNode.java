package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 25 （增加条件：去重）
 * @author yangzyh
 * @date 2021/11/3 22:49
 */

public class MergeNode {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode mergedHead = null;
        if(l1.val < l2.val) {
            mergedHead = l1;
            mergedHead.next = mergeTwoLists(l1.next, l2);
        } else if(l1.val > l2.val) {
            mergedHead = l2;
            mergedHead.next = mergeTwoLists(l1, l2.next);
        } else  {
            // l1和l2 相等时去重
            mergedHead = l1;
            mergedHead.next = mergeTwoLists(l1.next, l2.next);
        }

        return mergedHead;
    }

    /**
     *
     * 时间复杂度为 O(kn×logk)
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        if(left > right){
            return null;
        }
        int mid = (left +right) >> 1;
        // 分而治之，厉害
        return mergeTwoLists(merge(lists, left ,mid), merge(lists, mid+1, right));
    }


}
