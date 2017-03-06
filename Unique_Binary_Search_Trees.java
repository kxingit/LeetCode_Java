/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class Solution {
    public int numTrees(int n) {
        // 1:51 - 1:54 - 2:00
        if(n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int k = 1; k <= i; k++) {
                dp[i] += dp[k - 1] * dp[i - k];
            }
        }
        return dp[n];
    }
}
