/*
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // 4:54 - 4:58 - 5:10
        List<Integer> values = new ArrayList();
        inorder(root, values);
        
        PriorityQueue<Integer> pq = new PriorityQueue(values.size(), (a, b) -> {
            if(Math.abs((double)(Integer)a - target) < Math.abs((double)(Integer)b - target)) {
                return -1;
            } else {
                return 1;
            }
            });
        
        for(Integer val : values) {
            pq.add(val);
        }
        
        List<Integer> res = new ArrayList();
        
        for(int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> values) {
        if(root == null) return;
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }
}


// v2
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // 4:54 - 4:58 - 5:10 - 5:18 improved
        List<Integer> values = new ArrayList();
        
        PriorityQueue<Integer> pq = new PriorityQueue(k, (a, b) -> {
            if(Math.abs((double)(Integer)a - target) < Math.abs((double)(Integer)b - target)) {
                return -1;
            } else {
                return 1;
            }
            });
 
        inorder(root, pq);
        
        List<Integer> res = new ArrayList();
        
        for(int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        
        return res;
    }
    
    public void inorder(TreeNode root, PriorityQueue<Integer> pq) {
        if(root == null) return;
        inorder(root.left, pq);
        pq.add(root.val);
        inorder(root.right, pq);
    }
}


// v3
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // 9:25 - 9:34
        PriorityQueue<Integer> pq = new PriorityQueue(k, (a, b) -> {
           if(Math.abs(target - (double)(int)a) < Math.abs(target - (double)(int)b)) {
               return 1; 
           } else {
               return -1;
           }
        });
        
        inorder(root, pq, k, target);
        
        List<Integer> res = new ArrayList();
        while(pq.size() > 0) {
            res.add(pq.poll());
        }
        
        return res;
    }
    
    public void inorder(TreeNode root, PriorityQueue<Integer> pq, int k, double target) {
        if(root == null) return;
        inorder(root.left, pq, k, target);
        if(pq.size() < k) {
            pq.add(root.val);
        } else {
            if(Math.abs(target - root.val) < Math.abs(target - pq.peek())) {
                pq.poll();
                pq.add(root.val);
            }
        }
        inorder(root.right, pq, k, target);
    }
}
