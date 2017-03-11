/*
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class Solution {
    public int rob(TreeNode root) {
        // 4:30 - 4:38
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    private int[] dfs(TreeNode root) {
        int[] result = new int[2];
        if(root == null) return result;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }
}

// v2
public class Solution {
    public int rob(TreeNode root) {
        // 9:32 - 9:38
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    private int[] dfs(TreeNode root) {
        int[] result = new int[2]; // 0: root selected; 1: root not selected
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left); 
        int[] right = dfs(root. right);
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }
}


// v3: more recursions, slower
public class Solution {
    public int rob(TreeNode root) {
        // 2:04 - 2:10
        // if(root == null) return 0;
        return Math.max(robRoot(root), robNoRoot(root));
    }
    
    private int robRoot(TreeNode root) {
        if(root == null) return 0;
        return root.val + robNoRoot(root.left) + robNoRoot(root.right);
    }
    
    private int robNoRoot(TreeNode root) {
        if(root == null) return 0;
        return Math.max(robRoot(root.left), robNoRoot(root.left)) 
            + Math.max(robRoot(root.right), robNoRoot(root.right));
    }
}

// v4
public class Solution {
    public int rob(TreeNode root) {
        // 2:14 - 2:18
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if(root == null) {
            res[0] = 0; // rob root
            res[1] = 0;
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
