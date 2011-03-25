/*
Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // 7:17
	// 76 / 117 test cases passed.
        List<TreeNode> res = new ArrayList();
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        
        List<TreeNode> leaves = new ArrayList();
        inorder(root, leaves);
        List<List<TreeNode>> levels = levelorder(root);
        List<List<TreeNode>> leftlevels = levelorder(root.left);
        List<List<TreeNode>> rightlevels = levelorder(root.right);
        
        HashSet<TreeNode> atBound = new HashSet();
        // List<TreeNode> leftbound = new ArrayList();
        // List<TreeNode> rightbound = new ArrayList();
        // for(int i = 0; i < levels.size(); i++) {
        //     atBound.add(levels.get(i).get(0));
        //     atBound.add(levels.get(i).get(levels.get(i).size() - 1));
        // }
        // TreeNode tmpnode = root;
        // while(tmpnode != null) {
        //     leftbound.add(tmpnode);
        //     tmpnode = tmpnode.left;
        // }
        // tmpnode = root;
        // while(tmpnode != null) {
        //     rightbound.add(tmpnode);
        //     tmpnode = tmpnode.right;
        // }
        res.add(root);
        HashSet<TreeNode> added = new HashSet();
        added.add(root);
        if(root.left != null) {
            for(int i = 0; i < leftlevels.size(); i++) {
                added.add(leftlevels.get(i).get(0));
                res.add(leftlevels.get(i).get(0));
                atBound.add(leftlevels.get(i).get(0));
            }
        } else {
            added.add(root);
            res.add(root);
            atBound.add(root);
        }
        
        if(root.right != null) {
            for(int i = rightlevels.size() - 1; i >= 0; i--) {
                atBound.add(rightlevels.get(i).get(rightlevels.get(i).size() - 1));
            }
        }
        // for(TreeNode node : leftbound) {
        //     res.add(node);
        //     added.add(node);
        // }
        for(TreeNode leave : leaves) {
            if(!atBound.contains(leave) && !added.contains(leave)) {
                res.add(leave);
                added.add(leave);
            }
        }
        if(root.right != null) {
            for(int i = rightlevels.size() - 1; i >= 0; i--) {
                if(!added.contains(rightlevels.get(i).get(rightlevels.get(i).size() - 1))) {
                    res.add(rightlevels.get(i).get(rightlevels.get(i).size() - 1));
                }
            }
        }
        // for(TreeNode node : rightbound) {
        //     if(!added.contains(node)) {
        //         res.add(node);
        //     }
        // }
        
        for(TreeNode node : res) {
            result.add(node.val);
        }
        
        return result;
    }
    
    List<List<TreeNode>> levelorder(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if(root == null) return res;
        q.add(root);
        while(q.size() > 0) {
            int n = q.size();
            List<TreeNode> level = new ArrayList();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(new ArrayList(level));
        }
        return res;
    }
    
    public void inorder(TreeNode root, List<TreeNode> leaves) {
        if(root == null) return;
        inorder(root.left, leaves);
        if(root.left == null && root.right == null) {
            leaves.add(root);
        }
        inorder(root.right, leaves);
    }
}
