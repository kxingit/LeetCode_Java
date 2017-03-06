/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 3:19 - 3:21
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        if(q == null) return p == null;
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
