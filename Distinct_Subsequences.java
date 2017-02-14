/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++) dp[i][0] = 1;
        
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(s.charAt(i) != t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                }
            }
        }
        return dp[m][n];
    }
}

// v2
public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 0; i < m ; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(s.charAt(i) != t.charAt(j)) {
                    dp[j + 1] = dp[j + 1];
                } else {
                    dp[j + 1] = dp[j] + dp[j + 1];
                }
            }
        }
        return dp[n];
    }
}
