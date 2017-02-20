/*
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 *
 */
public class Solution {
    public int integerBreak(int n) {
        // 12:03 - 12:05
        if(n == 0 || n == 1) return 0;
        int[] dp = new int[n + 1]; // IB of 'n'
        Arrays.fill(dp, 1);
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}

// v2
public class Solution {
    public int integerBreak(int n) {
        // 1:12 - 1:16
        if(n == 0 || n == 1) return 0;
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}

// v3
public class Solution {
    public int integerBreak(int n) {
        // 1:12 - 1:16
        if(n == 0 || n == 1) return 0;
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}

// v4
public class Solution {
    public int integerBreak(int n) {
        // 11:34 - 11:42
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(j * (i - j), Math.max(dp[i], dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
}
