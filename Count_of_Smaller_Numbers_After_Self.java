/*
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 */

// TLE: 15 / 16 test cases passed.
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // 1:39 - 1:41
        int n = nums.length;
        List<Integer> res = new ArrayList();
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] < nums[i]) count++;
            }
            res.add(count);
        }
        return res;
    }
}

// v2 BST
public class Solution {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		res.add(0);
		for(int i = nums.length - 2; i >= 0; i--) {
			int count = insertNode(root, nums[i]);
			res.add(count);
		}
		Collections.reverse(res);
		return res;
	}

	public int insertNode(TreeNode root, int val) {
		int thisCount = 0;
		while(true) {
			if(val <= root.val) {
				root.count++;
				if(root.left == null) {
					root.left = new TreeNode(val); break;
				} else {
					root = root.left;
				}
			} else {
				thisCount += root.count;
				if(root.right == null) {
					root.right = new TreeNode(val); break;
				} else {
					root = root.right;
				}
			}
		}
		return thisCount;
	}
}

class TreeNode {
	TreeNode left; 
	TreeNode right;
	int val;
	int count = 1;
	public TreeNode(int val) {
		this.val = val;
	}
}
