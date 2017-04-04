/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
// kn -> k/2 * 2n -> k/4 * 4n -> ... -> k/k * kn, each of which has O(kn). Total: O(knlogk)
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 10:45 - 10:53
        if(lists.length == 0) return null;
        List<ListNode> list = new ArrayList(Arrays.asList(lists));
        while(list.size() > 1) {
            List<ListNode> newList = new ArrayList();
            for(int i = 0; i + 1 < list.size(); i = i + 2) {
                newList.add(merge(list.get(i), list.get(i + 1)));
            }
            if(list.size() % 2 == 1) {
                newList.add(list.get(list.size() - 1));
            }
            list = newList;
        }
        
        return list.get(0);
    }
    
    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if(n1 != null) {
            p.next = n1;
        }
        if(n2 != null) {
            p.next = n2;
        }
        
        return dummy.next;
    }
}

// v2
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 11:12 - 11:18
        if(lists.length == 0) return null;
        List<ListNode> list = new ArrayList(Arrays.asList(lists));
        while(list.size() > 1) {
            List<ListNode> tmp = new ArrayList();
            for(int i = 0; i + 1 < list.size(); i = i + 2) {
                tmp.add(merge(list.get(i), list.get(i + 1)));
            }
            if(list.size() % 2 == 1) {
                tmp.add(list.get(list.size() - 1));
            }
            list = tmp;
        }
        return list.get(0);
    }
    
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        if(node1 != null) {
            p.next = node1;
        }
        if(node2 != null) {
            p.next = node2;
        }
        
        return dummy.next;
    }
}
