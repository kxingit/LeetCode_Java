/* 
 * Invert a binary tree. 
 */
public class Solution {
	public TreeNode invertTree(TreeNode root) {
		// 1:40 - 1:41
		if(root == null) return null;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}
}
