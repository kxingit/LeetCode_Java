/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 11:52 - 11:56
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(0, new ArrayList<Integer>(level));
        }
        return result;
    }
}

// v2 Final
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 10:40 - 10:43
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(0, level);
        }
        return result;
    }
}
