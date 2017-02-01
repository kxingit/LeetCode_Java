/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 7:28 - 7:55
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> q = new ArrayList<TreeNode>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.get(0);
                q.remove(0);
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(new ArrayList<Integer>(level));
        }
        return result;
    }
}


// v2
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return result;
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(new ArrayList<Integer>(level));
        }
        return result;
    }
}
