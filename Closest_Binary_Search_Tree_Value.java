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

// v2
public class Solution {
    double diff = Long.MAX_VALUE;
    int cand;
    public int closestValue(TreeNode root, double target) {
        // 9:18 - 9:22 - 9:24
        if(Math.abs((double)root.val - target) < diff) {
            diff = Math.abs((double)root.val - target);
            cand = root.val;
        }
        
        if(target > root.val && root.right != null) { 
            closestValue(root.right, target);
        } 
        
        if(target < root.val && root.left != null) { // cannot else
            closestValue(root.left, target);
        }
        
        return cand;
    }
}
