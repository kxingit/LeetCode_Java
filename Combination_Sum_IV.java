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

// v3
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 9:56 - 9:58
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

// v4
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 5:00 - 5:05
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++) {
            for(int num : nums) {
                if(i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}

// v5
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 2:03 - 2:27
        int n = nums.length, m = target;
        // int[][] dp = new int[m + 1][n + 1];
        // for(int j = 0; j <= n; j++) {
        //     dp[0][j] = 1;
        // }
         
        // for(int i = 1; i <= m; i++) {  
        //     for(int j = 0; j < n; j++) {
        //         dp[i][j + 1] += dp[i][j];
        //         if(i - nums[j] >= 0) {
        //             dp[i][j + 1] += dp[i - nums[j]][j];
        //         }
        //         System.out.print(dp[i][n]);
        //     }
        //     System.out.print(dp[i][n] + " ");
        // }
        // return dp[m][n];
        int[] dp = new int[m + 1];
        dp[0] = 1;
         
        for(int i = 1; i <= m; i++) {  
            for(int j = 0; j < n; j++) {
                if(i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[m];
    }
}
