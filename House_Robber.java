/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class Solution {
    public int rob(int[] nums) {
        // 6:10 - 6:16
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        
        for(int i = 3; i < n; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}

// v2
public class Solution {
    public int rob(int[] nums) {
        // 6:33 - 6:35
        int n = nums.length;
        int[] dp = new int[n + 1];
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(nums[i -1] + dp[i - 2], dp[i - 1]);
        }
        return dp[n];
    }
}

// v3: rolling array
public class Solution {
    public int rob(int[] nums) {
        // 6:33 - 6:35
        int n = nums.length;
        int[] dp = new int[2];
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= n; i++) {
            dp[i % 2] = Math.max(nums[i -1] + dp[(i - 2) % 2], dp[(i - 1) % 2]);
        }
        return dp[n % 2];
    }
}
