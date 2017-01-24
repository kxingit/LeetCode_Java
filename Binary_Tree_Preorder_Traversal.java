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
