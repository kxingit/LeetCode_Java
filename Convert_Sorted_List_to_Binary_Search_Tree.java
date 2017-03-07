/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
    // ListNode ;
    private int getLen(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    public TreeNode sortedListToBST(ListNode head) {
        // 9:09 - 9:14
        int n = getLen(head);
        return toBST(head, n);
    }
    private TreeNode toBST(ListNode head, int n) {
        if(n <= 0) return null;
        int mid = n / 2;
        TreeNode left = toBST(head, mid);
        for(int i = 0; i < mid; i++) head = head.next;
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = toBST(head, n - mid - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}

// v2
public class Solution {
    // 9:48 - 9:52
    private ListNode curr;
    private int getLen(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = getLen(head);
        curr = head; 
        return toBST(n);
    }
    
    private TreeNode toBST(int n) {
        if(n <= 0) return null;
        int mid = n / 2;
        
        TreeNode left = toBST(mid);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next; // moved 'mid' times
        TreeNode right = toBST(n - mid - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
