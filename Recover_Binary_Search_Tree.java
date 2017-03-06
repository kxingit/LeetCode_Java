/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        // 2:53 - 3:00
        List<Integer> val = new ArrayList();
        List<TreeNode> node = new ArrayList();
        inorder(root, node, val);
        Collections.sort(val);
        // val.sort((a, b) -> a - b);
        for(int i = 0; i < val.size(); i++) {
            node.get(i).val = val.get(i);
        }
    }
    private void inorder(TreeNode root, List node, List val) {
        if(root == null) return;
        inorder(root.left, node, val);
        node.add(root);
        val.add(root.val);
        inorder(root.right, node, val);
    }
}
