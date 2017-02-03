/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 12:09 - 12:13
        List<Integer> result = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                result.add(nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}

// v2
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) {
                result.add(Math.abs(nums[i]));
            }
             nums[idx] *= -1;
        }
        return result;
    }
}
