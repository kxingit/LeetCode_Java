/*
 * Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?
 */
public class Solution {
    public int backPackII(int m, int[] A, int V[]) {
        // 5:14 - 5:17
        int[] dp = new int[m + 1];
        for(int i = 0; i < A.length; i++) {
            for(int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }
}

// v2
public class Solution {
    public int backPackII(int m, int[] A, int V[]) {
        // 9:39 － 9:54
        int[][] dp = new int[A.length + 1][m + 1];
        for(int i = 0; i < A.length; i++) {
            for(int j = m; j > 0; j--) {
                if(j >= A[i]) {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + V[i]);
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        return dp[A.length][m];
    }
}

// v3: Final
public class Solution {
    public int backPackII(int m, int[] A, int V[]) {
        // 11:40 - 11:42
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j < A[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + V[i]);
                }
            }
        }
        return dp[n][m];
    }
}
