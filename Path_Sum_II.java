/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
 */
public class Solution {
	public int curr = 0;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		// 2:12 - 2:31
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> solution = new ArrayList<Integer>();
		dfsFind(root, curr, sum, solution, result);
		return result;
	}
	private void dfsFind(TreeNode root, int curr, int sum, List<Integer> solution, List<List<Integer>> result) {
		if(root == null) return;
		solution.add(root.val);
		curr += root.val;
		if(root.left == null && root.right == null && curr == sum) {
			result.add(new ArrayList<Integer>(solution));
		}
		dfsFind(root.left, curr, sum, solution, result); 
		dfsFind(root.right, curr, sum, solution, result);
		solution.remove(solution.size() - 1);
		curr -= root.val;
	}
}


// v2
public class Solution {
    public int curr = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 2:35 - 2:40
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        dfsFind(root, sum, curr, solution, result);
        return result;
    }
    private void dfsFind(TreeNode root, int sum, int curr, List<Integer> solution, List<List<Integer>> result) {
        if(root == null) return;
        curr += root.val;
        solution.add(root.val);
        if(root.left == null && root.right == null && curr == sum) {
            result.add(new ArrayList<Integer>(solution));
        }
        dfsFind(root.left, sum, curr, solution, result);
        dfsFind(root.right, sum, curr, solution, result);
        curr -= root.val;
        solution.remove(solution.size() - 1);
    }
}

// v3
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 9:23 - 9:31
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        int curr = 0;
        dfs(root, sum, curr, solution, result);
        return result;
    }
    private void dfs(TreeNode root, int sum, int curr, List<Integer> solution, List<List<Integer>> result) {
        if(root == null) return;
        solution.add(root.val);
        curr += root.val;
        if(root.left == null && root.right == null) {
            if(curr == sum) {
                result.add(new ArrayList<Integer>(solution));
            }
        }
        dfs(root.left, sum, curr, solution, result);
        dfs(root.right, sum, curr, solution, result);
        solution.remove(solution.size() - 1);
    }
}
