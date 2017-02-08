/*
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        // 2:31
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(Integer num : map.keySet()) {
            if(map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}

// v2
public class Solution {
    public int singleNumber(int[] nums) {
        // 11:13 - 11:19
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); // new
        }
        for(Integer i : map.keySet()) {
            if(map.get(i) == 1) return i;
        }
        return -1;
    }
}
