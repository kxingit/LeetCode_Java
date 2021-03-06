/*
 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *
 *  Note: The solution set must not contain duplicate subsets. 
 */
public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> solution = new ArrayList<Integer>();
	Arrays.sort(nums);
	getSub(nums, 0, solution, result);
	return result;
  }
  private void getSub(int[] nums, int start, List<Integer> solution, List<List<Integer>> result) {
	result.add(new ArrayList<Integer>(solution));
	for(int i = start; i < nums.length; i++) {
	  if(i > start && nums[i] == nums[i - 1]) {
		continue;
	  }
	  solution.add(nums[i]);
	  getSub(nums, i + 1, solution, result);
	  solution.remove(solution.size() - 1);
	}
  }
}


// v2
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 11:28 - 11:34
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(nums);
        getSub2(nums, 0, solution, result);
        return result;
    }
    private void getSub2(int[] nums, int start, List<Integer> solution, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(solution));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            solution.add(nums[i]);
            getSub2(nums, i + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
    }
}

// v3
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 4:25 - 4:34 - 4:40
        List<List<Integer>> res = new ArrayList();
        List<Integer> solution = new ArrayList();
        Arrays.sort(nums); // !!
        dfs(nums, 0, solution, res);
        return res;
    }
    
    public void dfs(int[] nums, int pos, List<Integer> solution, List<List<Integer>> res) {
        // if(pos == nums.length) { // wrong
        //     res.add(new ArrayList(solution));
        //     return;
        // }
        res.add(new ArrayList(solution));
        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i - 1]) continue;
            solution.add(nums[i]);
            dfs(nums, i + 1, solution, res);
            solution.remove(solution.size() - 1);
        }
    }
}

// v4
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 1:53 - 1:57 - 2:00
        List<List<Integer>> res = new ArrayList();
        List<Integer> solution = new ArrayList();
        Arrays.sort(nums);
        dfs(nums, 0, solution, res);
        return res;
    }
    
    public void dfs(int[] nums, int pos, List<Integer> solution, List<List<Integer>> res) {
        res.add(new ArrayList(solution)); // for all 
        
        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i - 1]) continue;
            solution.add(nums[i]); // typo, 'i' not 'pos'
            dfs(nums, i + 1, solution, res);
            solution.remove(solution.size() - 1);
        }
    }
}
