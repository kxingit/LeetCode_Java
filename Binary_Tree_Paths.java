/*
 * Given a binary tree, return all root-to-leaf paths. 
 */
public class Solution {
	TreeNode originalRoot;
	public List<String> binaryTreePaths(TreeNode root) {
		// 2:44 - 3:00
		originalRoot = root;
		List<String> result = new ArrayList<String>();
		String solution = "";
		if(root == null) return result;
		dfsPath(root, solution, result); 
		return result;
	}
	private void dfsPath(TreeNode root, String solution, List<String> result) {
		if(root == null) return;
		if(root != originalRoot) solution += "->";
		solution += Integer.toString(root.val);
		if(root.left == null && root.right == null) {
			result.add(solution);
		}
		dfsPath(root.left, solution, result);
		dfsPath(root.right, solution,result);
	}
}


// v2
public class Solution {
	public TreeNode originalRoot;
	public List<String> binaryTreePaths(TreeNode root) {
		// 3:24 - 3:29
		originalRoot = root;
		List<String> result = new ArrayList<String>();
		String solution = "";
		dfsPath(root, solution, result);
		return result;
	}
	private void dfsPath(TreeNode root, String solution, List<String> result) {
		if(root == null) return;
		if(root != originalRoot) solution += "->";
		solution += Integer.toString(root.val);
		if(root.left == null && root.right == null) {
			result.add(solution);
		}
		dfsPath(root.left, solution, result);
		dfsPath(root.right, solution, result);
	}
}


// v3
public class Solution {
    private TreeNode originalRoot;
    public List<String> binaryTreePaths(TreeNode root) {
        // 9:55 - 9:58
        originalRoot = root;
        List<String> result = new ArrayList<String>();
        String solution = "";
        dfs(root, solution, result);
        return result;
    }
    private void dfs(TreeNode root, String solution, List<String> result) {
        if(root == null) return;
        if(root != originalRoot) solution += "->";
        solution += root.val;
        if(root.left == null && root.right == null) {
            result.add(solution);
        }
        dfs(root.left, solution, result);
        dfs(root.right, solution, result);
    }
}

// v4
public class Solution {
    TreeNode rt;
    public List<String> binaryTreePaths(TreeNode root) {
        rt = root;
        List<String> result = new ArrayList<String>();
        String solution = "";
        dfs(root, solution, result);
        return result;
    }
    private void dfs(TreeNode root, String solution, List<String> result) {
        if(root == null) return;
        if(root != rt) solution += "->";
        solution += Integer.toString(root.val);
        if(root.left == null && root.right == null) {
            result.add(solution);
        }
        dfs(root.left, solution, result);
        dfs(root.right, solution, result);
    }
}


// v5
public class Solution {
    private TreeNode rt;
    public List<String> binaryTreePaths(TreeNode root) {
        // 12:24 - 12:28
        rt = root;
        List<String> result = new ArrayList<String>();
        String solution = "";
        dfs(root, solution, result);
        return result;
    }
    private void dfs(TreeNode root, String solution, List<String> result) {
        if(root == null) return;
        if(root != rt) solution += "->";
        solution += root.val;
        if(root.left == null && root.right == null) {
            result.add(solution);
        }
        dfs(root.left, solution, result);
        dfs(root.right, solution, result);
    }
}

// v6
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // 10:29 - 10:33
        List<String> res = new ArrayList();
        String solution = "";
        
        dfs(root, solution, res);
        
        return res;
    }
    
    public void dfs(TreeNode root, String solution, List<String> res) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            String tmp = solution + "->" + root.val;
            res.add(tmp.substring(2, tmp.length()));
        }
        if(root.left != null) {
            dfs(root.left, solution + "->" + root.val, res);
        }
        if(root.right != null) {
            dfs(root.right, solution + "->" + root.val, res);
        }
    }
}

// v7 
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // 10:29 - 10:33 
        List<String> res = new ArrayList();
        String solution = "";
        
        dfs(root, solution, res);
        
        return res;
    }
    
    public void dfs(TreeNode root, String solution, List<String> res) {
        if(root == null) return;
        if(!solution.equals("")) {
            solution += "->";
        }
        solution += root.val;
        if(root.left == null && root.right == null) {
            res.add(solution);
        }
        dfs(root.left, solution, res);
        dfs(root.right, solution, res);
    }
}

// v8
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // 9:56 - 10:01
        List<String> res = new ArrayList();
        String solution = "";
        dfs(root, solution, res);
        return res;
    }
    public void dfs(TreeNode root, String solution, List<String> res) {
        if(root == null) return;
        if(!solution.equals("")) solution += "->";
        solution += root.val;
        if(root.left == null && root.right == null) {
            res.add(solution);
        }
        
        dfs(root.left, solution, res);
        dfs(root.right, solution, res);
    }
}
