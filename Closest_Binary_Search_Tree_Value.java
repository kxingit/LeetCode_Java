/*
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 */
public class Solution {
    double mindiff = Long.MAX_VALUE;
    int cand;
    
    public int closestValue(TreeNode root, double target) {
        // 6:05 - 6:14
        if(Math.abs((double)root.val - target) < mindiff) {
            cand = root.val;
            mindiff = Math.abs((double)root.val - target);
        }
        if(root.right != null && target > root.val) {
            closestValue(root.right, target);
        }
        if(root.left != null && target < root.val) {
            closestValue(root.left, target);
        }
        return cand;
    }
}
