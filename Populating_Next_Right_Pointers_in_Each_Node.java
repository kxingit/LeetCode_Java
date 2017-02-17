/*
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        // 12:57 - 1:10
        TreeLinkNode p = root;
        while(p != null) {
            TreeLinkNode first = p.left;
            while(p != null) {
                if(p.left == null) return;
                p.left.next = p.right;
                if(p.next == null) {
                    p = first;
                    break;
                }
                p.right.next = p.next.left;
                p = p.next;
            }
            p = first;
        }
        return;
    }
}

// v2
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null) {
            TreeLinkNode first = root.left;
            while(root.left != null) {
                root.left.next = root.right;
                if(root.next == null) {
                    break;
                }
                root.right.next = root.next.left;
                root = root.next;
            }
            root = first;
        }
    }
}

// v3
public class Solution {
    public void connect(TreeLinkNode root) {
        // 10:34 - 10:39
        TreeLinkNode first = root;
        while(root != null) {
            first = root.left;
            while(root != null) {
                if(root.left == null) return;
                root.left.next = root.right;
                if(root.next != null) {
                    root.right.next = root.next.left;
                }
                root = root.next;
            }
            root = first;
        }
    }
}
