/*
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 */
// TLE: 10 / 17 test cases passed.
public class Solution {
    private int res = 0;
    public int combinationSum4(int[] nums, int target) {
        // 5:13 - 5:16
        dfs(nums, target, 0);
        return res;
    }
    private void dfs(int[] nums, int target, int curr) {
        if(curr == target) {
            res++;
            return;
        }
        if(curr > target) return;
        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            dfs(nums, target, curr);
            curr -= nums[i];
        }
    }
}

// v2
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp 5:28 - 5:32
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(Integer num : nums) {
                if(i - num >= 0) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
