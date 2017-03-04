/*
 * Find the sum of all left leaves in a given binary tree.
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // 12:59 - 1:02
        if(root == null) return 0;
        int res = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        } else {
            res += sumOfLeftLeaves(root.left);
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }
}

// v2
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // 12:59 - 1:02 - 1:10
        if(root == null) return 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
