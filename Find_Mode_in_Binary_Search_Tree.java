/*
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 */
public class Solution {
    public int[] findMode(TreeNode root) {
        // 9:04 - 9:19
        Stack<TreeNode> stack = new Stack();
        HashMap<Integer, Integer> count = new HashMap();
        while(stack.size() > 0 || root != null) {
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val);
                count.put(root.val, count.getOrDefault(root.val, 0) + 1);
                root = root.right;
            }
        }
        
        int maxcount = 0;
        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            maxcount = Math.max(maxcount, e.getValue());
        }
        
        List<Integer> res = new ArrayList();
        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            if(e.getValue() == maxcount) {
                res.add(e.getKey());
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}

// v2
public class Solution {
    public int[] findMode(TreeNode root) {
        // 9:04 - 9:19 - 9:23
        Stack<TreeNode> stack = new Stack();
        HashMap<Integer, Integer> count = new HashMap();
        inorder(root, count);
        
        int maxcount = 0;
        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            maxcount = Math.max(maxcount, e.getValue());
        }
        
        List<Integer> res = new ArrayList();
        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            if(e.getValue() == maxcount) {
                res.add(e.getKey());
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    public void inorder(TreeNode root, HashMap<Integer, Integer> count) {
        if(root == null) return;
        inorder(root.left, count);
        count.put(root.val, count.getOrDefault(root.val, 0) + 1);
        inorder(root.right, count);
    }
}

// v3
public class Solution {
    int curval = 0, curcount = 0, maxcount = 0;
    List<Integer> res = new ArrayList();
    public int[] findMode(TreeNode root) {
        // 9:48 - 10:25
        if(root == null) return new int[0];
        
        inorder(root);
        
        int[] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        
        return ret;
        
    }
    
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(curval != root.val) {
            curcount = 1;
            curval = root.val;
        } else {
            curcount++;
        }
        
        if(curcount > maxcount) {
            maxcount = curcount;
            res.clear();
            res.add(curval);
        } else if(curcount == maxcount) {
            res.add(curval);
        }
        
        inorder(root.right);
    }
}
