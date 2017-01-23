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
