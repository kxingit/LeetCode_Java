/*
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] A) {
        // 12:38 - 12:45
        if(A == null || A[0] == null) return 0;
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                } 
                if(i == 0 && j == 0) {
                    dp[i][j] = A[0][0] == 0 ? 1 : 0;
                } else if(i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

// v2
public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        // 3:22 - 3:28
        if(grid == null || grid[0] == null) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
