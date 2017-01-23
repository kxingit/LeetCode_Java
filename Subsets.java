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
