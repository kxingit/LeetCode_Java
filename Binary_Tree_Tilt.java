/*
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.
*/
public class Solution {
    public int findTilt(TreeNode root) {
        // 8:57 - 9:00
        if(root == null) return 0;
        return findTilt(root.left) + findTilt(root.right) + Math.abs(sum(root.left) - sum(root.right));
    }
    
    public int sum(TreeNode root) {
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
