import com.yzy.demo.algorithm.structure.linklist.ListNode;

public class InsertGCD {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        while (node.next != null) {
            node.next = new ListNode(getGCD(node.val, node.next.val));
            node = node.next.next;
        }
        return head;
    }

    public int getGCD(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b =temp;
        }
        return a;
    }
}
