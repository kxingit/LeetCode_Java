/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// v2
public class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2) return n;
        int[] dp = new int[2];
        dp[1] = 1;
        dp[2 % 2] = 2;
        for(int i = 3; i < n + 1; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}
