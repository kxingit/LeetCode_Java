/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
*/
public class Solution {
    public int minCostII(int[][] costs) {
        // 12:12 - 12:19
        int n = costs.length;
        if(n == 0) return 0;    
        int k = costs[0].length;
        
        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                if(i == 0) {
                    dp[0][j] = costs[0][j];
                    continue;
                }
                for(int x = 0; x < k; x++) {
                    if(x == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + costs[i][j]);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }
}
