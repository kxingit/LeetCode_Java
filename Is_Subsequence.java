/*
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 */

// Memory Limit Exceeded 14 / 14 test cases passed.
public class Solution {
    public boolean isSubsequence(String s, String t) {
        // 3:07 - 3:10
        int m = s.length(), n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0; i < n + 1; i++) dp[0][i] = true;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
               if(s.charAt(i - 1) != t.charAt(j - 1)) {
                   dp[i][j] = dp[i][j - 1];
               } else {
                   dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
               }
            }
        }
        return dp[m][n];
    }
}

// v2: rolling array
public class Solution {
    public boolean isSubsequence(String s, String t) {
        // 3:07 - 3:14
        int m = s.length(), n = t.length();
        boolean[][] dp = new boolean[m + 1][2];
        for(int i = 0; i < 2; i++) dp[0][i] = true;
        
        for(int j = 1; j <= n; j++) {   
            for(int i = 1; i <= m; i++) {
               if(s.charAt(i - 1) != t.charAt(j - 1)) {
                   dp[i][j % 2] = dp[i][(j - 1) % 2];
               } else {
                   dp[i][j % 2] = dp[i - 1][(j - 1) % 2] || dp[i][(j - 1) % 2];
               }
            }
        }
        return dp[m][n % 2];
    }
}

