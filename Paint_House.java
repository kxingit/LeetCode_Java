/*
   There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

   The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
   */
public class Solution {
    public int minCost(int[][] costs) {
        // 9:39 - 9:48
        int m = costs.length;
        if(m == 0) return 0;
        int[][] dp = new int[m][3];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(k == j) continue;
                    dp[i][j] = Math.min(dp[i - 1][k] + costs[i][j], dp[i][j]) ;
                }
            }
        }
        
        return Math.min(dp[m - 1][0], Math.min(dp[m - 1][1], dp[m - 1][2]));
    }
}

// v2
public class Solution {
    public int minCost(int[][] costs) {
        // 10:14 - 10:21
        int n = costs.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][3];
        for(int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++) {
                    if(k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                }
            }
        }
        
        return Math.min(dp[n - 1][2],Math.min(dp[n - 1][0], dp[n - 1][1]));
    }
}
