/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 1:26 - 1:42
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0; 
        int res = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 1:44 - 1:49
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}

// v3
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 1:55 - 2:01
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}


// v4
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 10:16 - 10:26
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) { // !!!
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]); // !!!
            }
        }
        return res;
    }
}


// v5
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 2:03 - 2:30
        int res = 1;
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } 
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// v6
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 9:32 - 9:41
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n]; // length of the longest subseq from the first 'n' elements
        Arrays.fill(dp, 1);
        int res = 1;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// v7
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 12:04 - 12:12
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n + 1]; // LIS ending with 'n'th element
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + 1);
                }
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}

// v8
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 4:50 - 4:53
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
