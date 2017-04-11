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

// v3
public class Solution {
  public ListNode reverseList(ListNode head) {
	// 9:51 - 9:53
	ListNode newhead = null;
	while(head != null) { // java judge
	  ListNode temp = head.next;
	  head.next = newhead;
	  newhead = head;
	  head = temp;
	}
	return newhead;
  }
}

// v4
public class Solution {
    public ListNode reverseList(ListNode head) {
        // 5:37 - 5:38
        ListNode p = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = p;
            p = head;
            head = tmp;
        }
        return p;
    }
}

// v5
public class Solution {
    public ListNode reverseList(ListNode head) {
        // 9:56 - 9:58
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
