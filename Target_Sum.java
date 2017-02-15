/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // 2:00 - 3:00
        int m = 2001;
        int shift = m / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1]; // sum + 1000
        // for(int i = 0; i < n + 1; i++) dp[i][0 + shift] = 1;
        dp[0][shift] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j - nums[i] >= 0) {
                   dp[i + 1][j] += dp[i][j - nums[i]];
                }
                if(j + nums[i] <= m) {
                    dp[i + 1][j] += dp[i][j + nums[i]];
                }
            }
        }
        if(S > shift) return 0;
        return dp[n][S + shift];
    }
}
