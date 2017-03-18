/*
   Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
   */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 10:24
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        boolean found = false;
        while(stack.size() > 0 || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(found) return root;
                if(root == p) found = true;
                root = root.right;
            }
        }
        return null;
    }
}
