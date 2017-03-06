/*
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        // 12:03 - 12:10 - 12:20
        // Divide and Conque
        if(n == 0) return new ArrayList<TreeNode>();
        return gen(1, n);
    }
    private List<TreeNode> gen(int l, int r) {
        List<TreeNode> res = new ArrayList();
        if(l > r) {
            res.add(null);
            return res;
        }
        for(int i = l; i <= r; i++) {
            List<TreeNode> leftlist = gen(l, i - 1);
            List<TreeNode> rightlist = gen(i + 1, r);
            for(int il = 0; il < leftlist.size(); il++) {
                for(int ir = 0; ir < rightlist.size(); ir++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftlist.get(il);
                    root.right = rightlist.get(ir);
                    res.add(root);
                }
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        // 1:29 - 1:32
        List<TreeNode> res = new ArrayList();
        if(n == 0) return res;
        return gen(1, n);
    }
    private List<TreeNode> gen(int l, int r) {
        List<TreeNode> res = new ArrayList();
        if(l > r) {
            res.add(null);
            return res;
        }
        for(int i = l; i <= r; i++) {
            List<TreeNode> leftlist = gen(l, i - 1);
            List<TreeNode> rightlist = gen(i + 1, r);
            for(TreeNode left : leftlist) {
                for(TreeNode right : rightlist) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
