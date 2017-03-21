/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 */

// hard to track virtical orders
public class Solution {
    // 4:37 - 4:51
    int label = 0;
    int minlabel = 0, maxlabel = 0;
    HashMap<Integer, Integer> map = new LinkedHashMap();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        preorder(root);
        
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i < maxlabel - minlabel + 1; i++) {
            res.add(new ArrayList<Integer>());
        }
        
        for(Integer key : map.keySet()) {
            int label = map.get(key);
            int idx = label - minlabel;
            res.get(idx).add(key);
        }
        
        return res;
    }
    
    public void preorder(TreeNode root) {
        if(root == null) return;
        
        map.put(root.val, label);
        minlabel = Math.min(minlabel, label);
        maxlabel = Math.max(maxlabel, label);
        
        label--;
        preorder(root.left);
        label++;
        
        label++;
        preorder(root.right);
        label--;
    }
}

// v2
public class Solution {
    // 4:37 - 4:51 - 4:56
    int label = 0;
    int minlabel = 0, maxlabel = 0;
    HashMap<TreeNode, Integer> map = new LinkedHashMap();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        preorder(root);
        
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        for(int i = 0; i < maxlabel - minlabel + 1; i++) {
            res.add(new ArrayList<Integer>());
        }
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0) {
            TreeNode node = q.poll();
            int label = map.get(node);
            int idx = label - minlabel;
            res.get(idx).add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
 
        return res;
    }
    
    public void preorder(TreeNode root) {
        if(root == null) return;
        
        map.put(root, label);
        minlabel = Math.min(minlabel, label);
        maxlabel = Math.max(maxlabel, label);
        
        label--;
        preorder(root.left);
        label++;
        
        label++;
        preorder(root.right);
        label--;
    }
}
