/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        // 11:03 - 11:10
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                dp[i] = nums[i];
            }
            else {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// v2
public class Solution {
    public int maxSubArray(int[] nums) {
        // 11:03 - 11:10
        int n = nums.length;
        if(n == 0) return 0;
        int dp = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                dp = nums[i];
            }
            else {
                dp = Math.max(nums[i], nums[i] + dp);
            }
            res = Math.max(res, dp);
        }
        return res;
    }
}

// v3
public class Solution {
    public int maxSubArray(int[] nums) {
        // 10:59 - 10:01
        int n = nums.length;
        int[] dp = new int[n];
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
