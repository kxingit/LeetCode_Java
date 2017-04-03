/*
 *  Given a set of distinct integers, nums, return all possible subsets.
 *
 *  Note: The solution set must not contain duplicate subsets. 
 */
public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> solution = new ArrayList<Integer>();
	result.add(solution);
	getSub(nums, 0, solution, result);
	return result;
  }
  public void getSub(int[] nums, int start, List<Integer> solution, List<List<Integer>> result) {
	for(int i = start; i < nums.length; i++) {
	  solution.add(nums[i]);
	  result.add(new ArrayList<Integer>(solution)); // add a real one
	  getSub(nums, i + 1, solution, result);
	  solution.remove(solution.size() - 1);
	}
  }
}


// v2
public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> solution = new ArrayList<Integer>();
	getSub(nums, 0, solution, result);
	return result;
  }

  public void getSub(int[] nums, int start, List<Integer> solution, List<List<Integer>> result) {
	result.add(new ArrayList<Integer>(solution));
	for(int i = start; i < nums.length; i++) {
	  solution.add(nums[i]);
	  getSub(nums, i + 1, solution, result);
	  solution.remove(solution.size() - 1);
	}
  }
}

// v3
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 11:19 - 11:23
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        getSub(nums, 0, solution, result);
        return result;
    }
    private void getSub(int[] nums, int start, List<Integer> solution, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(solution));
        for(int i = start; i < nums.length; i++) {
            solution.add(nums[i]);
            getSub(nums, i + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
    }
}


// v4
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 5:13 - 5:17
        List<List<Integer>> res = new ArrayList();
        List<Integer> solution = new ArrayList();
        dfs(nums, 0, solution, res);
        return res;
    }
    
    public void dfs(int[] nums, int pos, List<Integer> solution, List<List<Integer>> res) {
        if(pos == nums.length) {
            res.add(new ArrayList(solution));
            return;
        }
        dfs(nums, pos + 1, solution, res);
        solution.add(nums[pos]);
        dfs(nums, pos + 1, solution, res);
        solution.remove(solution.size() - 1);
    }
}
