/*
 * Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * Can use multiple times. Can have different orders
 *
 * Given nums = [1, 2, 4], target = 4
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]
 */
public class Solution {
    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target+1];
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == j) dp[j]++;
                if (nums[i] <= j) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}

// v2
public class Solution {
    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;            
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}

// v3
public class Solution {
    public int backPackVI(int[] nums, int target) {
        // 12:09 - 12:11
        int n = nums.length;
        int m = target;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for(int j = 1; j <= target; j++) {
            for(int i = 0; i < n; i++) {
                if(j < nums[i]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[m];
    }
}