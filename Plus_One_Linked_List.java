/*
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public ListNode plusOne(ListNode head) {
        // 10:49 - 10:58 // bug - 11:02
        head = reverse(head);
        ListNode node = head;
        int curr = node.val + 1;
        int carry = curr / 10;
        curr = curr % 10;
        node.val = curr;
        node = node.next;
        while(node != null) {
            curr = node.val + carry;
            carry = curr / 10;
            curr = curr % 10;
            node.val = curr;
            node = node.next;
        }
        if(carry > 0) {
            node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(1);
        }
        
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode node = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = node;
            node = head;
            head = tmp;
        }
        return node;
    }
}

// v2
public class Solution {
    public ListNode plusOne(ListNode head) {
        // 10:49 - 10:58 // bug - 11:02
        head = reverse(head);
        ListNode node = head;
        ListNode pre = node;
        int carry = 1;
        while(node != null) {
            int curr = node.val + carry;
            carry = curr / 10;
            curr = curr % 10;
            node.val = curr;
            pre = node;
            node = node.next;
        }
        if(carry > 0) {
            pre.next = new ListNode(1);
        }
        
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode node = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = node;
            node = head;
            head = tmp;
        }
        return node;
    }
}


// v3
public class Solution {
    public ListNode plusOne(ListNode head) {
        // 8:55 - 9:00
        head = reverse(head);
        
        int carry = 1;
        ListNode node = head;
        ListNode pre = node;
        
        while(node != null) {
            int curr = node.val + carry;
            node.val = curr % 10;
            carry = curr / 10;
            pre = node;
            node = node.next;
        }
        if(carry > 0) {
            pre.next = new ListNode(1);
        }
        
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode newhead = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = newhead;
            newhead = head;
            head = tmp;
        }
        return newhead;
    }
}
