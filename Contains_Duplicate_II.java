/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
// TLE: 22 / 23 test cases passed.
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 5:17 - 5:20
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}


// v2
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 5:21 - 5:23
        HashMap<Integer, Integer> map_last_index = new HashMap();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(map_last_index.containsKey(nums[i])) {
                if(i - map_last_index.get(nums[i]) <= k) {
                    return true;
                }
            }
            map_last_index.put(nums[i], i);
        }
        return false;
    }
}
