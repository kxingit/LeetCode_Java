/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */

/**
 *  * Definition for a binary tree node.
 *   * public class TreeNode {
 *    *     int val;
 *     *     TreeNode left;
 *      *     TreeNode right;
 *       *     TreeNode(int x) { val = x; }
 *        * }
 *         */
public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> result = new ArrayList<Integer>();
	preorder(root, result);
	return result;
  }
  private void preorder(TreeNode root, List<Integer> result) {
	if(root == null) return;
	result.add(root.val);
	preorder(root.left, result);
	preorder(root.right, result);
  }
}

// v2
public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
	// 1:11 - 1:14
	List<Integer> result = new ArrayList<Integer>();
	preorder(root, result);
	return result;
  }
  private void preorder(TreeNode root, List<Integer> result) {
	if(root == null) return;
	result.add(root.val);
	preorder(root.left, result);
	preorder(root.right, result);
  }
}


// v3 iteratively
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 12:58 - 1:01
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return result;
    }
}


// v4
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 1:58 - 2:02
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null) stack.push(root);
        while(!stack.empty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        return result;
    }
}


// v5
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 9:21 - 9:24
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.empty()) {
            root = stack.pop();
            result.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return result;
    }
}

// v6 
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		// 10:58 - 11:01
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.empty()) {
			if(root !=null) {
				stack.push(root);
				result.add(root.val);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}
		return result;
	}
}
