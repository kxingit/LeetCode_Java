/*
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 */
public class Solution {
    public int backPack(int m, int[] A) {
        // write your code here
        int[] dp = new int[m + 1];
        for(int i = 0; i < A.length; i++) {
            for(int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
    }
}

// v2
public class Solution {
    public int backPack(int m, int[] A) {
        // 9:07
        int[][] dp = new int[A.length + 1][m + 1];
        for(int i = 0; i < A.length; i++) {
            for(int j = m; j > 0; j--) {
                dp[i + 1][j] = dp[i][j];
                if(j >= A[i]){
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + A[i]);
                }
            }
        }
        return dp[A.length][m];
    }
}

// v3: Final
public class Solution {
    public int backPack(int m, int[] A) {
        // 11：35 - 11:39
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j < A[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + A[i]);
                }
            }
        }
        return dp[n][m];
    }
}
