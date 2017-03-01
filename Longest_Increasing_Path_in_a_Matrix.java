/*
 * Longest Increasing Path in a Matrix
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 */
// LTE: 134 / 137 test cases passed.
public class Solution {
    private int result = 1;
    public int longestIncreasingPath(int[][] matrix) {
        // 10:51 - 11:04
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int curr = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] isVisited = new boolean[m][n];
                getMax(matrix, i, j, 0, isVisited);
            }
        }
        return result;
    }
    private void getMax(int[][] matrix, int i, int j, int curr, boolean[][] isVisited) {
        int m = matrix.length, n = matrix[0].length;
        isVisited[i][j] = true;
        curr++;
        result = Math.max(result, curr);
        if(i - 1 >= 0 && !isVisited[i - 1][j] && matrix[i - 1][j] > matrix[i][j]) {
            getMax(matrix, i - 1, j, curr, isVisited);
        }
        if(j - 1 >= 0 && !isVisited[i][j - 1] && matrix[i][j - 1] > matrix[i][j]) {
            getMax(matrix, i, j - 1, curr, isVisited);
        }
        if(i + 1 < m && !isVisited[i + 1][j] && matrix[i + 1][j] > matrix[i][j]) {
            getMax(matrix, i + 1, j, curr, isVisited);
        }
        if(j + 1 < n && !isVisited[i][j + 1] && matrix[i][j + 1] > matrix[i][j]) {
            getMax(matrix, i, j + 1, curr, isVisited);
        }
        isVisited[i][j] = false; // recoil state
    }
}

// v2
public class Solution {
    private int result = 1;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        // 10:51 - 11:04 - 12:03
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result = Math.max(result, getMax(matrix, i, j, dp));
            }
        }
        return result;
    }
    private int getMax(int[][] matrix, int i, int j, int[][] dp) {
        if(dp[i][j] > 0) return dp[i][j];
        int m = matrix.length, n = matrix[0].length;
        int res = 1;
        if(i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            res = Math.max(res, getMax(matrix, i - 1, j, dp) + 1);
        }
        if(j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            res = Math.max(res, getMax(matrix, i, j - 1, dp) + 1);
        }
        if(i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
            res = Math.max(res, getMax(matrix, i + 1, j, dp) + 1);
        }
        if(j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
            res = Math.max(res, getMax(matrix, i, j + 1, dp) + 1);
        }
        dp[i][j] = res;
        return res;
    }
}

// v3
public class Solution {
    private int[][] dp;
    int m, n;
    int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        // 12:16 - 12:29
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 1;
        m = matrix.length; n = matrix[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int i, int j) {
        if(dp[i][j] > 0) return dp[i][j];
        dp[i][j] = 1;
        for(int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j])
                continue;
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, x, y));
        }
        return dp[i][j];
    }
}

// v4
public class Solution {
    // 1:07 - 1:14
    int[][] dp;
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int res = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int i, int j) {
        if(dp[i][j] > 0) return dp[i][j];
        dp[i][j] = 1;
        for(int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, x, y));
        }
        return dp[i][j];
    }
}

// v5
public class Solution {
    // 1:39 - 1:46
    int[][] dp;
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        dp = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int i, int j) {
        if(dp[i][j] > 0) return dp[i][j];
        dp[i][j] = 1;
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n) continue;
            if(matrix[x][y] <= matrix[i][j]) continue;
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, x, y));
        }
        return dp[i][j];
    }
}
