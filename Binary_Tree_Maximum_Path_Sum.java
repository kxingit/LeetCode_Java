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


// v7
public class Solution {
    // 11:58 - 12:25
    public class RetType {
        int singleMax;
        int pathMax;
        RetType(int s, int p) {
            this.singleMax = s;
            this.pathMax = p;
        }
    }
    public int maxPathSum(TreeNode root) {
        return getMax(root).pathMax;
    }
    private RetType getMax(TreeNode root) {
        if(root == null) {
            return new RetType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        RetType left = getMax(root.left);
        RetType right = getMax(root.right);
        
        int single = root.val;
        if(left.singleMax > 0) single = Math.max(single, root.val + left.singleMax); // overflow
        if(right.singleMax > 0) single = Math.max(single, root.val + right.singleMax);
        
        int path = root.val;
        if(left.singleMax > 0) path += left.singleMax;
        if(right.singleMax > 0) path += right.singleMax;
        path = Math.max(path, left.pathMax);
        path = Math.max(path, right.pathMax);
        return new RetType(single, path);
    }
}

// v8 Time Limit Exceeded 92 / 92 test cases passed.
public class Solution {
    public int maxPathSum(TreeNode root) {
        // 9:40 - 9:50
        if(root == null) return Integer.MIN_VALUE;
        int res = root.val;
        int sl = singleMax(root.left), sr = singleMax(root.right);
        if(sl > 0) res += sl;
        if(sr > 0) res += sr;
        return Math.max(res, Math.max(maxPathSum(root.left), maxPathSum(root.right)));
    }
    private int singleMax(TreeNode root) { // private??
        if(root == null) return 0;
        int res = root.val;
        res = Math.max(res, root.val + singleMax(root.left));
        res = Math.max(res, root.val + singleMax(root.right));
        return res;
    }
}


// v9
public class Solution {
    // 9:52 - 10:13
    public class RtType {
        int singleMax, pathMax;
        RtType(int s, int p) {
            this.singleMax = s;
            this.pathMax = p;
        }
    }
    public int maxPathSum(TreeNode root) {
        return getMax(root).pathMax;
    }
    private RtType getMax(TreeNode root) {
        if(root == null) return new RtType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        RtType left = getMax(root.left);
        RtType right = getMax(root.right);
        
        int single = root.val;
        single = root.val + Math.max(0, Math.max(left.singleMax, right.singleMax));
        
        int path = root.val;
        if(left.singleMax > 0) path += left.singleMax;
        if(right.singleMax > 0) path += right.singleMax;
        path = Math.max(path, Math.max(left.pathMax, right.pathMax));
        
        return new RtType(single, path);
    }
}


// v10 Final Version
public class Solution {
    class RtType {
        int single, path;
        RtType(int s, int p) {
            this.single = s;
            this.path = p;
        }
    }
    public int maxPathSum(TreeNode root) {
        // 10:16 - 10:21
        return getMax(root).path;
    }
    public RtType getMax(TreeNode root) {
        int single = Integer.MIN_VALUE, path = Integer.MIN_VALUE;
        if(root == null) return new RtType(single, path);
        
        RtType left = getMax(root.left);
        RtType right = getMax(root.right);
        
        single = root.val;
        single += Math.max(0, Math.max(left.single, right.single));
        
        path = root.val;
        if(left.single > 0) path += left.single;
        if(right.single > 0) path += right.single;
        path = Math.max(path, Math.max(left.path, right.path));
        
        return new RtType(single, path);
    }
}

// v11
public class Solution {
    class ResultType {
        int rootMax, max;
        ResultType(int rm, int m) {
            rootMax = rm;
            max = m;
        }
    }
    public int maxPathSum(TreeNode root) {
        // 4:00 - 4:06
        return getMax(root).max;
    }
    private ResultType getMax(TreeNode root) {
        if(root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        
        ResultType left = getMax(root.left);
        ResultType right = getMax(root.right);
        
        int rootMax = root.val;
        rootMax += Math.max(0, Math.max(left.rootMax, right.rootMax));
        
        int max = root.val;
        if(left.rootMax > 0) max += left.rootMax;
        if(right.rootMax > 0) max += right.rootMax;
        max = Math.max(max, Math.max(left.max, right.max));
        
        return new ResultType(rootMax, max);
    }
}
