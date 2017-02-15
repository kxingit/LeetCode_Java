/*
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
 *
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int canGet = max1(nums, 0, nums.length - 1);
        return canGet >= sum - canGet;
    }
    private int max1(int[] nums, int i, int j) {
        if(i > j) return 0;
        if(i == j) return nums[i];
        int left1 = max1(nums, i + 2, j) + nums[i];
        int left2 = max1(nums, i + 1, j - 1) + nums[i];
        int right1 = max1(nums, i + 1, j - 1) + nums[j];
        int right2 = max1(nums, i, j - 2) + nums[j];
        return Math.max(Math.min(left1, left2), Math.min(right1, right2));
    }
}

// v2
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int canGet = max1(nums, 0, nums.length - 1, dp);
        return canGet >= sum - canGet;
    }
    private int max1(int[] nums, int i, int j, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == j) {
            dp[i][j] = nums[i]; 
            return dp[i][j];
        }
        int left1 = max1(nums, i + 2, j, dp) + nums[i];
        int left2 = max1(nums, i + 1, j - 1, dp) + nums[i];
        int right1 = max1(nums, i + 1, j - 1, dp) + nums[j];
        int right2 = max1(nums, i, j - 2, dp) + nums[j];
        dp[i][j] = Math.max(Math.min(left1, left2), Math.min(right1, right2));
        return dp[i][j];
    }
}
