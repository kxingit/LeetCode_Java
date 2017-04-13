/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 10:36 - 10:41
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while(l1 != null && l2 != null) {
            int curr = l1.val + l2.val + carry;
            carry = curr / 10;
            p.next = new ListNode(curr % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            int curr = l1.val + carry;
            carry = curr / 10;
            p.next = new ListNode(curr % 10);
            p = p.next;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            int curr = l2.val + carry;
            carry = curr / 10;
            p.next = new ListNode(curr % 10);
            p = p.next;
            l2 = l2.next;
        }
        
        if(carry > 0) {
            p.next = new ListNode(carry);
        }
        
        return reverse(dummy.next);
    }
    
    public ListNode reverse(ListNode p) {
        ListNode head = null;
        while(p != null) {
            ListNode tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        return head;
    }
}
