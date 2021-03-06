/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 12:07 - 12:09
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

// v2
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 9:09 - 9:12
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                return true;
            }
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
