/*
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
  public int minDepth(TreeNode root) {
	// 13:36 - 13:39
	if(root == null) return 0;
	if(root.left == null && root.right == null) {
	  return 1;
	}
	if(root.left != null && root.right == null) {
	  return 1 + minDepth(root.left);
	}
	if(root.right != null && root.left == null) {
	  return 1 + minDepth(root.right);
	}
	return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }
}
