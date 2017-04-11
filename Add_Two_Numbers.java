/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2:35 - 2:40
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null && l2 != null) {
            int curr = l1.val + l2.val + carry;
            carry = curr / 10;
            p.next = new ListNode(curr % 10);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        while(l1 != null) {
            int curr = l1.val + carry;
            carry = curr / 10;
            p.next = new ListNode(curr % 10);
            l1 = l1.next;
            p = p.next;
        }
        while(l2 != null) {
            int curr = l2.val + carry;
            carry = curr / 10;
            p.next = new ListNode(curr % 10);
            l2 = l2.next;
            p = p.next;
        }
        if(carry != 0) {
            p.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
