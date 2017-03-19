/*
   Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
   */
// Contest
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        // 9:15 - 9:23
        List<TreeNode> nodes = new ArrayList();
        List<Integer> vals = new ArrayList();
        inorder(root, nodes, vals);
        for(int i = vals.size() - 2; i >= 0; i--) {
            vals.set(i, vals.get(i) + vals.get(i + 1));
            nodes.get(i).val = vals.get(i);
        }
        return root;
    }
    
    public void inorder(TreeNode root, List nodes, List vals) {
        if(root == null) return;
        inorder(root.left, nodes, vals);
        nodes.add(root);
        vals.add(root.val);
        inorder(root.right, nodes, vals);
    }
}
