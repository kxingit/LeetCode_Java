/*
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 */
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        // 4:22 - 4:29
        if(root == null) return 0;
        int res = countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        if(isUni(root.left) && isUni(root.right) 
        && (root.left == null || root.val == root.left.val)
        && (root.right == null || root.val == root.right.val)) {
            res++;
        }
        return res;
    }
    
    public boolean isUni(TreeNode root) {
        if(root == null) return true;
        return (root.left == null || root.val == root.left.val) 
        && (root.right == null || root.val == root.right.val)
        && isUni(root.left) && isUni(root.right);
    }
}
