/*
   Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
   */
// contest
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // 8:57 - 9:01
        if(root == null) return 0;
        int res = depth(root.left) + depth(root.right); // root path
        res = Math.max(res, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
        return res;
    }
    
    private int depth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

// v2
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // 11:29 - 11:31
        if(root == null) {
            return 0;
        }
        return Math.max(depth(root.left) + depth(root.right),
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
       
    }
   
    public int depth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
