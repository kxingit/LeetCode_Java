/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class Solution {
    public int numSquares(int n) {
        // 4:36 - 4:40
        int[] dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++) dp[i] = i;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}
