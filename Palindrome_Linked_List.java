/*
Given a singly linked list, determine if it is a palindrome.
*/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // 3:17 - 3:26
        int n = 0;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newhead = null; // reverse starting from slow
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = newhead;
            newhead = slow;
            slow = tmp;
        }
        
        while(newhead != null) {
            if(newhead.val != head.val) {
                return false;
            }
            newhead = newhead.next;
            head = head.next;
        }
        
        return true;
    }
}
