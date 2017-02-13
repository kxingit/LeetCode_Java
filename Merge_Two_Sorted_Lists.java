/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 2:41 - 2:50
        ListNode head = null;;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                ListNode tmp = l1.next;
                l1.next = head;
                head = l1;
                l1 = tmp;
            } else {
                ListNode tmp = l2.next;
                l2.next = head;
                head = l2;
                l2 = tmp;
            }
        }
        while(l1 != null) {
            ListNode tmp = l1.next;
            l1.next = head;
            head = l1;
            l1 = tmp;
        }
        while(l2 != null) {
            ListNode tmp = l2.next;
            l2.next = head;
            head = l2;
            l2 = tmp;
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
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

// v2
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 2:55 - 3:07
        ListNode head = new ListNode(0);
        ListNode last = new ListNode(0);
        
        if(l1 != null && l2 != null) {
            if(l1.val < l2.val) head = l1;
            else head = l2;
        } else if(l1 == null) {
            return l2;
        } else {
            return l1;
        }
        
        while(l1 != null && l2 != null) {
            ListNode tmp = last;
            if(l1.val < l2.val) {
                last = l1;
                l1 = l1.next;
            } else {
                last = l2;
                l2 = l2.next;
            }
            tmp.next = last;
        }
 
        if(l1 != null) {
            last.next = l1;
        }
        if(l2 != null) {
            last.next = l2;
        }
        
        return head;
    }
}


// v3
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 3:20 - 3:23
        ListNode last = new ListNode(0);
        ListNode dummy = last;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }
        
        if(l1 != null) last.next = l1;
        if(l2 != null) last.next = l2;
        
        return dummy.next;
    }
}

// v4
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 12:15 - 12:21   
        ListNode dummy = new ListNode(0), last = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }
        if(l1 != null) last.next = l1;
        if(l2 != null) last.next = l2;
        return dummy.next;
    }
}
