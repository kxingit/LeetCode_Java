/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
	// 11:25 - 11: 28
	List<Integer> result = new ArrayList<Integer>();
	inorder(root, result);
	return result;
  }
  private void inorder(TreeNode root, List<Integer> result) {
	if(root == null) return;
	inorder(root.left, result);
	result.add(root.val);
	inorder(root.right, result);
  }
} 


// v2 iteratively
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1:45 - 1:48
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}

// v3
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 9:25 - 9:28
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return result;
        while(root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}


// v4
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 10:22 - 10:24
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}

// v5
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 11:46 - 11:47
        List<Integer> res = new ArrayList();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}

// v6
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 11:49 - 11:53
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new ArrayList();
        while(root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
