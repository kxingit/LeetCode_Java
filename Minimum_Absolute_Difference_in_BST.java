/*
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 */
public class Solution {
    int res = Integer.MAX_VALUE;
    Integer prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return res;
    }
    
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null) res = Math.min(res, Math.abs(root.val - prev));
        prev = root.val;
        inorder(root.right);
    }
}
