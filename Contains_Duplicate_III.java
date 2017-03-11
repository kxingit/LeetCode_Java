/*
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */

// TLE: 39 / 40 test cases passed.
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 10:43 - 10:45
        int n = nums.length;
        if(n < 2) return false;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(j - i <= k && Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}

// v2
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 12:18 - 12:26
        if(t < 0 || nums.length < 2) return false;
        SortedSet<Long> set = new TreeSet();
        for(int i = 0; i < nums.length; i++) {
            Long num = (long)nums[i];
            if(set.subSet(num - t, num + t + 1).size() > 0) {
                return true;
            }
            set.add(num);
            if(i >= k) { // >=
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
