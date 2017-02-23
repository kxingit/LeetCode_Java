/*
 * You need to find the largest value in each row of a binary tree.
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // 6:08 - 6:11
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        while(!q.isEmpty()) {
            int n = q.size();
            int currmax = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                currmax = Math.max(currmax, node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(currmax);
        }
        return res;
    }
}
