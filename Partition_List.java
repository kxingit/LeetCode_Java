/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // 11:39 - 11:42
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1, p2 = dummy2;
        while(head != null) {
            if(head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
