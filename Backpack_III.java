/*
 * Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m. What's the maximum value can you put into the backpack?
 */
public class Solution {
    public int backPackIII(int[] A, int[] V, int m) {
        // 5:22 - 5:24
        int[] dp = new int[m + 1];
        for(int i = 0; i < A.length; i++) {
            for(int j = A[i]; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }
}

// v2
public class Solution {
    public int backPackIII(int[] A, int[] V, int m) {
        // 10:16 - 10:20
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i + 1][j] = dp[i][j];
                if(j - A[i] >= 0) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i + 1][j - A[i]] + V[i]);
                }
            }
        }
        return dp[n][m];
    }
}

// v3: Final
public class Solution {
    public int backPackIII(int[] A, int[] V, int m) {
        // 11:48 - 11:51
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j < A[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - A[i]] + V[i]);
                }
            }
        }
        return dp[n][m];
    }
}
