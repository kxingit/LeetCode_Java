/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 */
public class Solution {
    // 11:06 - 11:09
    private int getLen(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int len = getLen(head);
        k = k % len;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        head = dummy;
        for(int i = 0; i < len - k; i++) {
            tail = tail.next;
        }
        for(int i = 0; i < len; i++) {
            head = head.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
}
