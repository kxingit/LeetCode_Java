/*  Given a binary tree, find the maximum path sum.
 *
 *  For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 */
public class Solution {
	private class ResultType {
		int singlePath, maxPath;
		ResultType(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	private ResultType dfsPath(TreeNode root) {
		if(root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		ResultType left = dfsPath(root.left);
		ResultType right = dfsPath(root.right);

		int singlePath = root.val + Math.max(left.singlePath, right.singlePath);
		singlePath = Math.max(singlePath, 0);

		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, root.val + left.singlePath + right.singlePath);

		return new ResultType(singlePath, maxPath);
	}

	public int maxPathSum(TreeNode root) {
		// 11:42 - 11:54
		return dfsPath(root).maxPath;
	}
}

// v2
public class Solution {
	private class ResultType {
		int singlePath, maxPath;
		ResultType(int s, int m) {
			this.singlePath = s;
			this.maxPath = m;
		}
	}
	private ResultType getMax(TreeNode root) {
		if(root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		ResultType left = getMax(root.left);
		ResultType right = getMax(root.right);

		int singlePath = Math.max(0, Math.max(root.val + left.singlePath, root.val + right.singlePath));
		int maxPath = Math.max(root.val + left.singlePath + right.singlePath, Math.max(left.maxPath, right.maxPath));
		return new ResultType(singlePath, maxPath);
	}

	public int maxPathSum(TreeNode root) {
		// 12:56 - 1:05
		return getMax(root).maxPath;
	}
}

// v3
public class Solution {
	private class ResultType {
		int singlePath, maxPath;
		ResultType(int s, int m) {
			this.singlePath = s;
			this.maxPath = m;
		}
	}
	private ResultType getPath(TreeNode root) {
		if(root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		ResultType left = getPath(root.left);
		ResultType right = getPath(root.right);

		int singlePath = Math.max(0, root.val + Math.max(left.singlePath, right.singlePath));
		int maxPath = Math.max(root.val + left.singlePath + right.singlePath, Math.max(left.maxPath, right.maxPath));

		return new ResultType(singlePath, maxPath);
	}
	public int maxPathSum(TreeNode root) {
		// 1:15 - 1:21
		return getPath(root).maxPath;
	}
}


// v4
public class Solution {
    private class ResultType {
        int singlePath, maxPath;
        ResultType(int s, int m) {
            this.singlePath = s;
            this.maxPath = m;
        }
    }
    public int maxPathSum(TreeNode root) {
        // 8:45 - 8:56
        return getMax(root).maxPath;
    }
    private ResultType getMax(TreeNode root) {
        if(root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = getMax(root.left);
        ResultType right = getMax(root.right);
        int singlePath = Math.max(0, root.val + Math.max(left.singlePath, right.singlePath));
        int maxPath = Math.max(Math.max(root.val + left.singlePath + right.singlePath, left.maxPath), right.maxPath);
        return new ResultType(singlePath, maxPath);
    }
}

// v5  Time Limit Exceeded 91 / 92 test cases passed.
public class Solution {
    public int maxPathSum(TreeNode root) {
        // 5:36
        int result = Integer.MIN_VALUE;
        if(root == null) return result;
        result = Math.max(result, root.val + singlePath(root.left) + singlePath(root.right));
        result = Math.max(result, maxPathSum(root.left));
        result = Math.max(result, maxPathSum(root.right));
        return result;
    }
    private int singlePath(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        res = Math.max(res, root.val + singlePath(root.left));
        res = Math.max(res, root.val + singlePath(root.right));
        return res;
    }
}

// v6
public class Solution {
    private class ResultType {
        int singleSum, maxSum;
        ResultType(int s, int m) {
            this.singleSum = s;
            this.maxSum = m;
        }
    }
    public int maxPathSum(TreeNode root) {
        // 11:13 - 11:21
        return getSum(root).maxSum;
    }
    private ResultType getSum(TreeNode root) {
        int singleSum = 0, maxSum = Integer.MIN_VALUE;
        if(root == null) {
            return new ResultType(singleSum, maxSum);
        }
        ResultType left = getSum(root.left);
        ResultType right = getSum(root.right);
 
        singleSum = Math.max(singleSum, root.val + left.singleSum);
        singleSum = Math.max(singleSum, root.val + right.singleSum);
        maxSum = Math.max(root.val + left.singleSum + right.singleSum, left.maxSum);
        maxSum = Math.max(maxSum, right.maxSum);
        return new ResultType(singleSum, maxSum);
    }
}
