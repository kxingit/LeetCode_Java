/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 */

// Time Limit Exceeded: 30 / 31 test cases passed.
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 11:19 - 11:27
        if(hasNode(root.left, p) && hasNode(root.left, q)) {
            return lowestCommonAncestor(root.left, p ,q);
        } else if(hasNode(root.right, p) && hasNode(root.right, q)) {
            return lowestCommonAncestor(root.right, p ,q);
        } else {
            return root;
        }
    }
    private boolean hasNode(TreeNode root, TreeNode node) {
        if(root == null) return false;
        if(root == node) return true;
        if(hasNode(root.left, node) || hasNode(root.right, node)) {
            return true;
        }
        return false;
    }
}

// v2
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode leftlca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightlca = lowestCommonAncestor(root.right, p, q);
        if(leftlca == null) return rightlca;
        if(rightlca == null) return leftlca;
        return root;
    }
}
