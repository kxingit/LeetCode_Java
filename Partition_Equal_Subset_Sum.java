/*
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */

// Time Limit Exceeded 89 / 104 test cases passed.
public class Solution {
    public boolean canPartition(int[] nums) {
        // 4:35 - 4:56
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        return dfs(nums, 0, 0, sum / 2);
    }
    private boolean dfs(int [] nums, int start, int curr, int target) {
        if(curr == target) return true;
        for(int i = start; i < nums.length; i++) {
            curr += nums[i];
            if(curr > target) continue;
            if(dfs(nums, i + 1, curr, target)) return true;
            curr -= nums[i];
        }
        return false;
    }
}

// v2: dp
public class Solution {
    public boolean canPartition(int[] nums) {
        // 5:59 - 6:02
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        
        boolean[] dp = new boolean[target + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}

// v3
public class Solution {
    public boolean canPartition(int[] nums) {
        // 12:44 - 12:58
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}

// v4
public class Solution {
    public boolean canPartition(int[] nums) {
        // 2:15 - 2:23
        int sum = 0, n = nums.length;
        if(n == 0) return false;
        for(int i = 0; i < n; i++) sum += nums[i];
        if(sum % 2 == 1) return false;
        sum /= 2;
        
        boolean [] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}


// v5
public class Solution {
    public boolean canPartition(int[] nums) {
        // 10:38 - 10:46
        int sum = 0, n = nums.length;
        for(int i = 0; i < n; i++) sum += nums[i];
        if(sum % 2 == 1) return false;
        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 1; i < n; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
