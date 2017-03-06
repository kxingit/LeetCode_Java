/*
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		// 10:05 -10:33
		if(root == null) return true;
		return  Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 // better to check depth first, using less stack
			&& isBalanced(root.left) && isBalanced(root.right); 
		// return  isBalanced(root.left) && isBalanced(root.right) 
		//         && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1; // Line 16: java.lang.StackOverflowError
	}
	private int getDepth(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
	}
}

// v2
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // 10:49 - 10:52
        if(root == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1
            && isBalanced(root.left) && isBalanced(root.right);
    }
    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}


// v3
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // 4:53 - 4:57
        if(root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1 + depth(root.right);
        if(root.right == null) return 1 + depth(root.left);
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

// v4
public class Solution {
    // 4:40 - 4:41
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
