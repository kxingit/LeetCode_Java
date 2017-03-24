/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Solution {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 2:41 - 2:44
        if(root == null) return true;

        if(!isValidBST(root.left)) return false;
        
        if(root.val <= leftmax) return false;
        prev = root.val;
        
        if(!isValidBST(root.right)) return false;
        
        return true;
    }
}

// v2
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // 2:48 - 2:53
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        
        if(root.left != null) {
            TreeNode node = root.left;
            while(node.right != null) {
                node = node.right;
            }
            int leftmax = node.val;
            if(root.val <= leftmax) return false;
        }
        
        if(!isValidBST(root.right)) return false;
        
        if(root.right != null) {
            TreeNode node = root.right;
            while(node.left != null) {
                node = node.left;
            }
            int rightmin = node.val;
            if(root.val >= rightmin) return false;
        }
        
        return true;
    }
}
