/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        // 9:13 - 9:14
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

// v2
public class Solution {
    public int singleNumber(int[] nums) {
        // 2:26 - 2:26
        if(nums.length == 0) return 0;
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
