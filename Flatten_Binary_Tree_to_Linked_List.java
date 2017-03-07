/*
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class Solution {
    public void flatten(TreeNode root) {
        // 10:00 - 10:06
        // Divide and Conquer
        flat(root);
    }
    private TreeNode flat(TreeNode root) {
        if(root == null) return null;
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        if(left != null) {
            TreeNode p = left;
            while(p.right != null) p = p.right;
            p.right = right;
            root.right = left;
            root.left = null;
        } 
        return root;
    }
}
