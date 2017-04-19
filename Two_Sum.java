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

// v2
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 4:22 - 4:24
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if(map.containsKey(gap)) {
                res[0] = map.get(gap);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

// v3
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2:13 - 2:15
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if(map.containsKey(gap)) {
                res[0] = map.get(gap);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

// v4
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 12:21 - 12:23
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if(map.containsKey(gap)) {
                res[0] = map.get(gap);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
