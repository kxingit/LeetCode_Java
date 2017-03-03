/*
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 */
// Reservoir sampling
public class Solution {
    // 10:40 - 10:49
    private ListNode head;
 
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        ListNode p = head;
        int res = p.val;
        Random r = new Random();
        while(p != null) {
            count++;
            // if(r.nextDouble() < 1.0 / count) {
            if(r.nextInt(count) == count - 1) { // use new at chance 1 / n
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
