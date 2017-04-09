/*
Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
*/
public class Solution {
    public int longestConsecutive(TreeNode root) {
        // 9:28 - 9:38 - 9:47
        Stack<TreeNode> stack = new Stack();
        int res = 0;
        
        while(stack.size() > 0 || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                int len = plus1len(root, root.val) + minus1len(root, root.val) - 1;
                res = Math.max(res, len);
                root = root.right;
            }
        }
        
        return res;
    }
    
    public int plus1len (TreeNode root, int val) {
        if(root == null) return 0;
        if(val != root.val) return 0;
        return 1 + Math.max(plus1len(root.left, val + 1), plus1len(root.right, val + 1));
    }
    public int minus1len (TreeNode root, int val) {
        if(root == null) return 0;
        if(val != root.val) return 0;
        return 1 + Math.max(minus1len(root.left, val - 1), minus1len(root.right, val - 1));
    }
}
