/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorder(root, result);
        return result;
    }
    private void postorder(TreeNode root, List<Integer> result) {
        if(root == null) return;
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}

