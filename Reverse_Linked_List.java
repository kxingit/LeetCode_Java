/*
 * Reverse a singly linked list.
 */
public class Solution {
  public ListNode reverseList(ListNode head) {
	// 2:56 - 3:01
	ListNode newhead = null; // should be null; not head
	while(head != null) {
	  ListNode temp = head.next;
	  head.next = newhead;
	  newhead = head;
	  head = temp;
	}
	return newhead;
  }
}

// v2
public class Solution {
  public ListNode reverseList(ListNode head) {
	// 3:03 - 3:05
	ListNode newhead = null;
	while(head != null) {
	  ListNode temp = head.next;
	  head.next = newhead;
	  newhead = head;
	  head = temp;
	}
	return newhead;
  }
}
