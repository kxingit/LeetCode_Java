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
