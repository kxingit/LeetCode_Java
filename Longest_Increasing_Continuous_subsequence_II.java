/*
 * Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
 */
// Time Limit Exceeded: 87% test cases passed.
public class Solution {
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // 12:34 - 12:42
        if(A == null || A.length == 0 || A[0].length == 0) return 0;
        int m = A.length, n = A[0].length;
        int res = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(A, i, j));
            }
        }
        return res;
    }
    private int dfs(int[][] A, int i, int j) {
        int m = A.length, n = A[0].length;
        if(i < 0 || j < 0 || i == m || j == n) {
            return 0;
        }
        int left = 0, right = 0, up = 0, down = 0;
        if(j >= 1 && A[i][j - 1] > A[i][j]) {
            left = dfs(A, i, j - 1);
        }
        if(i >= 1 && A[i - 1][j] > A[i][j]) {
            up = dfs(A, i - 1, j);
        }
        if(j <= n - 2 && A[i][j + 1] > A[i][j]) {
            right = dfs(A, i, j + 1);
        }
            if(i <= m - 2 && A[i + 1][j] > A[i][j]) {
            down = dfs(A, i + 1, j);
        }
        int res = 1 + Math.max(Math.max(left, right), Math.max(up, down));
        return res;
    }
}

// v2
public class Solution {
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // 12:34 - 12:42 - 12:57
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int m = A.length, n = A[0].length;
        int res = 1;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(A, i, j, dp));
            }
        }
        return res;
    }
    private int dfs(int[][] A, int i, int j, int[][] dp) {
        if(dp[i][j] > 0) return dp[i][j];
        int m = A.length, n = A[0].length;
        if(i < 0 || j < 0 || i == m || j == n) {
            dp[i][j] = 0;
            return 0;
        }
        int left = 0, right = 0, up = 0, down = 0;
        if(j >= 1 && A[i][j - 1] > A[i][j]) {
            left = dfs(A, i, j - 1, dp);
        }
        if(i >= 1 && A[i - 1][j] > A[i][j]) {
            up = dfs(A, i - 1, j, dp);
        }
        if(j <= n - 2 && A[i][j + 1] > A[i][j]) {
            right = dfs(A, i, j + 1, dp);
        }
        if(i <= m - 2 && A[i + 1][j] > A[i][j]) {
            down = dfs(A, i + 1, j, dp);
        }
        int res = 1 + Math.max(Math.max(left, right), Math.max(up, down));
        dp[i][j] = res;
        return res;
    }
}
