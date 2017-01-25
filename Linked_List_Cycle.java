/*
 * Given a linked list, determine if it has a cycle in it. 
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
	// 1:46 - 1:53
	if(head == null || head.next == null) {
	  return false;
	}
	ListNode slow = head.next, fast = head.next.next;
	while(slow != null && fast != null && fast.next != null) {
	  if(slow == fast) return true;
	  slow = slow.next;
	  fast = fast.next.next;
	}
	return false;
  }
}
// v2
public class Solution {
  public boolean hasCycle(ListNode head) {
	// 2:44 - 2:45
	ListNode slow = head, fast = head;
	while(fast != null && fast.next != null) {
	  slow = slow.next;
	  fast = fast.next.next;
	  if(fast == slow) {
		return true;
	  }
	}
	return false;
  }
}
