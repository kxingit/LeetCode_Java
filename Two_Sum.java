public class Solution {
  public int[] twoSum(int[] nums, int target) {
	int result[] = new int[2];
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	for(int i = 0; i < nums.length; i++) {
	  int gap = target - nums[i];
	  if(map.containsKey(gap)) {
		result[0] = i;
		result[1] = map.get(gap);
		return result;
	  } else {
		map.put(nums[i], i);
	  }
	}
	return result;
  }
}
