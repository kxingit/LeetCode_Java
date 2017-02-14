/*
 * Given n items with size nums[i] which an integer array and all positive numbers. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
 *
 * Each item may only be used once
 */
public class Solution {
    public int backPackV(int[] nums, int target) {
        int[] dp = new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (nums[i] == j) dp[j]++;
                else if (nums[i] < j) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}

// v2
public class Solution {
    public int backPackV(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
               dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}

// v3
public class Solution {
    public int backPackV(int[] nums, int target) {
        // 10:44 - 10:48
        int m = target, n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i + 1][j] = dp[i][j];
                if(j - nums[i] >= 0) {
                    if(j == nums[i]) dp[i + 1][j]++;
                    dp[i + 1][j] += dp[i][j - nums[i]];
                }
            }
        }
        return dp[n][m];
    }
}

// v4: Final
public class Solution {
    public int backPackV(int[] nums, int target) {
        // 12:00 - 12:04
        int n = nums.length;
        int m = target;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++) dp[i][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j < nums[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] + dp[i][j - nums[i]];
                }
            }
        }
        return dp[n][m];
    }
}
