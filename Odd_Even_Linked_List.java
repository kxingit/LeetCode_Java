/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 10:08 - 10:13
        ListNode preodd = new ListNode(0);
        ListNode preeven = new ListNode(0);
        ListNode podd = preodd, peven = preeven;
        boolean isEven = false;
        while(head != null) {
            isEven = !isEven;
            if(isEven) {
                podd.next = head;
                podd = podd.next;
            } else {
                peven.next = head;
                peven = peven.next;
            }
            head = head.next;
        }
        peven.next = null; // otherwise produce a circle
        podd.next = preeven.next;
        return preodd.next;
    }
}

// v2
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 10:40 - 10:48
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, preeven = head.next;
        while(odd != null && odd.next != null) {
            odd.next = odd.next.next;
            if(odd.next != null) odd = odd.next;
            even.next = odd == null ? null :odd.next;
            even = even.next;
        }
        odd.next = preeven;
        return head;
    }
}
