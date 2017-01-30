/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Solution {
	public int minPathSum(int[][] grid) {
		// 11:37 - 11:45
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
				} else if(i == 0) {
					dp[i][j] = grid[i][j] + dp[i][j - 1];
				} else if(j == 0) {
					dp[i][j] = grid[i][j] + dp[i - 1][j];
				} else {
					dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}

// v2 rolling array
public class Solution {
	public int minPathSum(int[][] grid) {
		// 11:37 - 11:45
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[2][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0) {
					dp[i % 2][j] = grid[i][j];
				} else if(i == 0) {
					dp[i % 2][j] = grid[i][j] + dp[i % 2][j - 1];
				} else if(j == 0) {
					dp[i % 2][j] = grid[i][j] + dp[(i - 1) % 2][j];
				} else {
					dp[i % 2][j] = grid[i][j] + Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
				}
			}
		}
		return dp[(m - 1) % 2][n - 1];
	}
}

// v3
public class Solution {
    public int minPathSum(int[][] grid) {
        // 9:00 - 9:05
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        int[][] dp = new int[2][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                else if (i == 0) {
                    dp[i % 2][j] = grid[i][j] + dp[i % 2][j - 1];
                } else if (j == 0) {
                    dp[i % 2][j] = grid[i][j] + dp[(i - 1) % 2][j];
                } else {
                    dp[i % 2][j] = grid[i][j] + Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }
}


// v4 some typing errors 
public class Solution {
    public int minPathSum(int[][] grid) {
        // 4:14 - 4:18
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        int[][] dp = new int[2][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[i % 2][j] = grid[i][j];
                } else if(i == 0) {
                    dp[i % 2][j] = dp[i % 2][j - 1] + grid[i][j];
                } else if(j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + grid[i][j];
                } else {
                    dp[i % 2][j] = grid[i][j] + Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }
}

