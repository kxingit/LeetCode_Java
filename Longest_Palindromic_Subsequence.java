/*
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        // 11:37 - 11:42
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                if(j == i) dp[j][i] = 1;
                else {
                    if(s.charAt(j) == s.charAt(i)) {
                        dp[j][i] = 2 + dp[j + 1][i - 1];
                    } else {
                        dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}


// v2
public class Solution {
    public int longestPalindromeSubseq(String s) {
        // 11:55 - 11:58
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        // dp[i][j] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j - 1]));
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
