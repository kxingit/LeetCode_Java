/*
 * Given a binary tree, find the leftmost value in the last row of the tree.
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        // 5:16 - 5:20
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int res = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if(i == 0) res = node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}
