/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null. 
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
	// 2:00 - 2:24
	if(head == null || head.next == null) {
	  return null;
	}
	ListNode slow = head.next, fast = head.next.next;
	while(slow != null && fast != null && fast.next != null) {
	  if(slow == fast) {
		fast = head;
		while(slow != fast) {
		  slow = slow.next;
		  fast = fast.next;
		}
		return slow;
	  }
	  slow = slow.next;
	  fast = fast.next.next;
	}
	return null;
  }
}


// v2
public class Solution {
  public ListNode detectCycle(ListNode head) {
	ListNode slow = head, fast = head;
	while(slow != null && fast != null && fast.next != null) {
	  slow = slow.next;
	  fast = fast.next.next;
	  if(slow == fast) { // has cycle
		fast = head;
		while(fast != slow) {
		  fast = fast.next;
		  slow = slow.next;
		}
		return slow;
	  }
	}
	return null;
  }
}


// v3
public class Solution {
  public ListNode detectCycle(ListNode head) {
	// 2:47 - 2:49
	ListNode slow = head, fast = head;
	while(fast != null && fast.next != null) {
	  slow = slow.next;
	  fast = fast.next.next;
	  if(slow == fast) { // has cycle
		while(head != slow) {
		  head = head.next;
		  slow = slow.next;
		}
		return head;
	  }
	}
	return null;
  }
}
