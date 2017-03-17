/*
   Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
   */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)  
            return null;  
        TreeNode left = root.left, right = root.right;  
        if(left == null) {
            return root;
        }

        TreeNode ret = upsideDownBinaryTree(left);  
        left.left = right;  
        left.right = root;  
        root.left = null;
        root.right = null;
        return ret;  
    }
}
