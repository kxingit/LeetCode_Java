/*
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class Solution {
    private int result = 0;
    public int pathSum(TreeNode root, int sum) {
        // 3:29 - 3:34
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, sum, 0, list);
        return result;
    }
    private void dfs(TreeNode root, int sum, int currsum, List<TreeNode> list) {
        if(root == null) return;
        currsum += root.val;
        list.add(root);
        if(currsum == sum) result++;
        int t = currsum;
        for(int i = 0; i < list.size() - 1; i++) {
            t -= list.get(i).val;
            if(t == sum) result++;
        }
        dfs(root.left, sum, currsum, list);
        dfs(root.right, sum, currsum, list);
        list.remove(list.size() - 1);
    }
}

// v2
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        // 5:05 - 5:10
        if(root == null) return 0;
        return singlePath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int singlePath(TreeNode root, int sum) {
        if(root == null) return 0;
        int result = 0;
        if(root.val == sum) result++;
        result = result + singlePath(root.left, sum - root.val) + singlePath(root.right, sum - root.val);
        return result;
    }
}
