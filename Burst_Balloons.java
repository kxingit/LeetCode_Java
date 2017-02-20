/*
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 */
public class Solution {
    public int DP(int i, int j, int[] nums, int[][] dp) {
        if (dp[i][j] > 0) return dp[i][j];
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], DP(i, x - 1, nums, dp) + nums[i - 1] * nums[x] * nums[j + 1] + DP(x + 1, j, nums, dp));
        }
        return dp[i][j];
    }
 
    public int maxCoins(int[] iNums) {
        int n = iNums.length;
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) nums[i + 1] = iNums[i];
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return DP(1, n, nums, dp);
    }
}

// v2 DP
public class Solution {
    public int maxCoins(int[] nums) {
        // 9:28 - 10:21
        int n = nums.length;
        int[] A = new int[n + 2];
        for(int i = 0; i < n; i++) A[i + 1] = nums[i];
        A[0] = 1; A[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return getMax(A, 1, n, dp);
    }
    private int getMax(int[] nums, int i, int j, int[][] dp) {
        if(dp[i][j] > 0) return dp[i][j];
        for(int k = i; k <= j; k++) {
            dp[i][j] = Math.max(dp[i][j], nums[i - 1] * nums[k] * nums[j + 1] + getMax(nums, i, k - 1, dp) + getMax(nums, k + 1, j, dp));
        }
        return dp[i][j];
    }
}

// v3: DFS Time Limit Exceeded 31 / 70 test cases passed.
public class Solution {
    public int maxCoins(int[] nums) {
        // 9:28 - 9:32
        int n = nums.length;
        int[] A = new int[n + 2];
        for(int i = 0; i < n; i++) A[i + 1] = nums[i];
        A[0] = 1; A[n + 1] = 1;
        return getMax(A, 1, n);
    }
    private int getMax(int[] nums, int i, int j) {
        int res = 0;
        for(int k = i; k <= j; k++) {
            res = Math.max(res, nums[i - 1] * nums[k] * nums[j + 1] + getMax(nums, i, k - 1) + getMax(nums, k + 1, j));
        }
        return res;
    }
}

// v4
public class Solution {
    public int maxCoins(int[] nums) {
        // 9:14 - 9:18 dfs - 9:21 DP, memorization search
        int n = nums.length;
        int[] A = new int[n + 2];
        for(int i = 0; i < n; i++) A[i + 1] = nums[i];
        A[0] = 1; A[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return getMax(A, 1, n, dp);
    }
    private int getMax(int[] A, int i, int j, int[][] dp) {
        if(dp[i][j] > 0) return dp[i][j];
        if(i == j) {
            dp[i][j] = A[i]; // not necessary 
        }
        for(int k = i; k <= j; k++) {
            dp[i][j] = Math.max(dp[i][j], A[k] * A[i - 1] * A[j + 1] + getMax(A, i, k - 1, dp) + getMax(A, k + 1, j, dp));
        }
        return dp[i][j];
    }
}


// v5
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] A = new int[n + 2];
        for(int i = 1; i <= n; i++) {
            A[i] = nums[i - 1];
        }
        A[0] = 1; A[n + 1] = 1;
        return getMax(A, 1, n);
    }
    
    private int getMax(int[] nums, int i, int j) {
        int res = 0;
        for(int k = i; k <= j; k++) {
            int curr = nums[k] * nums[i - 1] * nums[j + 1] + getMax(nums, i, k - 1) + getMax(nums, k + 1, j);
            res = Math.max(res, curr);
        }
        return res; 
    }
}
