/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // 1:36 - 1:38
        RandomListNode p = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        
        while(p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        
        p = head;
        while(p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        
        return map.get(head);
    }
}

// v2
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // 1:43 - 1:47 - 2:10
        if(head == null) return null;
         
        RandomListNode p = head;
        while(p != null) {
            RandomListNode tmp = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = tmp;
            p = tmp;
        }
         
        p = head;
        while(p != null) {
            if(p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
         
        p = head;
        RandomListNode newhead = head.next;
        while(p != null) {
            if(p.next.next == null) {
                p.next = null; // restore original tail
                break;
            }
            RandomListNode newnode = p.next;
            p.next = p.next.next;
            p = p.next;
            newnode.next = p.next;
        }
         
        return newhead;
    }
}

// v3
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // 2:11 - 2:16 - 2:19
        if(head == null) return null;
        
        RandomListNode p = head;
        while(p != null) {
            RandomListNode tmp = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = tmp;
            p = tmp;
        }
        
        p = head;
        while(p != null) {
            if(p.random != null) p.next.random = p.random.next;
            p = p.next.next;
        }
        
        RandomListNode newhead = head.next;
        p = head;
        while(p != null) {
            if(p.next.next == null) {
                p.next = null;
                break;
            }
            RandomListNode newp = p.next;
            p.next = p.next.next;
            p = p.next;
            newp.next = p.next;
        }
        
        return newhead;
    }
}
