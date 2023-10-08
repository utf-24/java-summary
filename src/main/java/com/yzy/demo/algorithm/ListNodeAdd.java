package com.yzy.demo.algorithm;

/**
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author young
 * @date 2019/8/11 11:41
 */

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     ListNode(int x, ListNode next) {
         val =x; this.next = next;
     }
 }
public class ListNodeAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curry = result;
        int carry = 0;
        while(l1!=null || l2!=null) {
            int val1 = l1!=null? l1.val:0;
            int val2 = l2!=null? l2.val:0;
            int sum = val1 + val2 + carry;
            carry = sum /10;
            curry.next = new ListNode(sum%10);
            curry = curry.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry >0){
            curry.next =new ListNode(carry);
        }

        return result.next;
    }

}
