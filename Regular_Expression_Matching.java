/*
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        // 12:32 - 12:42 - 1:18
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        for(int i = 0; i < m; ++ i)
             dp[i + 1][0] = false;
         for(int j = 0; j < n; ++ j)
             dp[0][j + 1] = '*' == p.charAt(j) && dp[0][j - 1];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(p.charAt(j) != '*') {
                    dp[i + 1][j + 1] = dp[i][j] && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] // '*' for 0 or 1
                        || ((p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) && dp[i][j + 1]); // s(i) matches p(j - 1)
                }
            }
        }
        
        return dp[m][n];
    }
}
