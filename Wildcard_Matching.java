/*
Implement wildcard pattern matching with support for '?' and '*'.
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        // 5:19
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
         
        int rows = s.length();
        int cols = p.length();
         
        boolean[][] dp = new boolean[rows + 1][cols + 1];
         
        dp[0][0] = true;
        for (int j = 1; j <= cols; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
         
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
         
        return dp[rows][cols];
    }
}

// v2
public class Solution {
    public boolean isMatch(String s, String p) {
        // 9:23 - 9:34
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for(int j = 0; j < n; j++) {
            if(p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j]; // '*' matches everything
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(p.charAt(j) != '*') {
                    if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } 
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j] || dp[i][j + 1];
                }
            }
        }
        
        return dp[m][n];
    }
}

// v3
public class Solution {
    public boolean isMatch(String s, String p) {
        // 10:07 - 10:14
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int j = 0; j < n; j++) { // empty s
            if(p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j];
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if(p.charAt(j) == '*') { // must specify '*'
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j] || dp[i][j + 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
