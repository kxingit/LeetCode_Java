/*
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 4:09 - 4:12
        if(head == null) return head;
        while(head.val == val) {
            return removeElements(head.next, val);
        }
        ListNode newhead = head;
        while(head.next != null) {
            if(head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return newhead;
    }
}
