/*
 * Given a complete binary tree, count the number of nodes
 */
// For a generic tree.
// TLE: 12 / 18 test cases passed.
public class Solution {
    public int countNodes(TreeNode root) {
        // 5:29
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// v2: wrong
public class Solution {
    public int countNodes(TreeNode root) {
        // 5:41 - 5:41
        int lh = 0, rh = 0;
        TreeNode node = root;
        while(node != null) {
            node = node.left;
            lh++;
        }
        node = root;
        while(node != null) {
            node = node.right;
            lh++; // Typo!!
        }
        if(lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// v3
public class Solution {
    public int countNodes(TreeNode root) {
        // 5:41 - 5:41
        int lh = 0, rh = 0;
        TreeNode node = root;
        while(node != null) {
            node = node.left;
            lh++;
        }
        node = root;
        while(node != null) {
            node = node.right;
            rh++; // typo, lh
        }
        if(lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// v4
public class Solution {
    public int countNodes(TreeNode root) {
        // 12:44 - 12:48
        if(root == null) return 0;
        int lefth = getLefth(root.left);
        int righth = getRighth(root.right);
        if(lefth == righth) return (1 << (lefth + 1)) - 1; // 2 ^ h - 1
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int getLefth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int res = 0;
        while(root != null) {
            root = root.left;
            res++;
        }
        
        return res;
    }
    
    private int getRighth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int res = 0;
        while(root != null) {
            root = root.right;
            res++;
        }
        
        return res;
    }
}
