/*
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class Solution {
    public int rob(int[] nums) {
        // 3:29 - 3:39
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
 
        int[] dp = new int[n]; // must rob 0
        dp[0] = nums[0];
        dp[1] = 0;
        dp[2] = nums[0] + nums[2];
        for(int i = 3; i < n; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        
        int[] dp2 = new int[n]; // must not rob 0
        dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++) {
            dp2[i] = nums[i] + Math.max(dp2[i - 2], dp2[i - 3]);
        }
        
        return Math.max(Math.max(dp[n - 2], dp[n - 3]), Math.max(dp2[n - 1], dp2[n - 2]));
    }
}

// v2
public class Solution {
    public int rob(int[] nums) {
        // 3:44 - 4:00
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        System.out.print(robhouse(nums, 0, n - 2)+""+robhouse(nums, 1, n -1)+" ");
        return Math.max(robhouse(nums, 0, n - 2), robhouse(nums, 1, n -1));
    }
    
    private int robhouse(int[] nums, int i, int j) {
        int n = j - i + 1;
        int[] dp = new int[n];
        if(n == 0) return 0;
        if(n == 1) return nums[0 + i];
        if(n == 2) return Math.max(nums[0 + i], nums[1 + i]);
        dp[0] = nums[0 + i]; // + i
        dp[1] = Math.max(nums[0 + i], nums[1 + i]);
        for(int k = 2; k < n; k++) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k + i]);
        }
        return dp[n - 1];
    }
}
