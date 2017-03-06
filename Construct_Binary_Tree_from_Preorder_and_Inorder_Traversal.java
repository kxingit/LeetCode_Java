/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 3:22 - 4:10
        int n = inorder.length;
        if(n == 0) return null;
        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    private TreeNode build(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij) {
        int n = inorder.length;
        if(ii > ij || pi >= n || pj < 0 || ii >= n || ij < 0) return null;
        TreeNode root = new TreeNode(preorder[pi]);
        int k = ii;
        for(; k <= ij; k++) {
            if(inorder[k] == preorder[pi]) {
                break;
            }
        }
        TreeNode left = build(preorder, pi + 1, pi + k - ii, inorder, ii, k - 1); // left len: k - ii
        TreeNode right = build(preorder, pi + k - ii + 1, pj, inorder, k + 1, ij); 
        root.left = left;
        root.right =right;
        return root;
    }
}
