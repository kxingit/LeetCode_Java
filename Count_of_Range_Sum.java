/*
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 */
// TLE: 56 / 61 test cases passed.
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // 9:12 - 9:22
        int n = nums.length;
        long[][] dp = new long[n + 1][n + 1];
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + nums[i];
                if(dp[i + 1][j + 1] >= lower && dp[i + 1][j + 1] <= upper) {
                    res++;
                }
            }
        }
        return res;
    }
}
