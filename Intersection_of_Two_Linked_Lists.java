/*
Write a program to find the node at which the intersection of two singly linked lists begins.
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 2:18 - 2:23
        int lenA = 0, lenB = 0;
        ListNode pA = headA, pB = headB;
        while(pA != null) {
            lenA++;
            pA = pA.next;
        }
        while(pB != null) {
            lenB++;
            pB = pB.next;
        }
         
        if(lenA < lenB) {
            ListNode tmp = headA;
            headA= headB;
            headB = tmp;
            int tmplen = lenA;
            lenA = lenB;
            lenB = tmplen;
        }
         
        for(int i = 0; i < lenA - lenB; i++) {
            headA = headA.next;
        }
         
        while(headA != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
         
        return null;
    }
}
