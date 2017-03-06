/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 2:30 - 2:34
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n1 + n2 != n3) return false;
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for(int i = 0; i < n1; i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for(int j = 0; j < n2; j++) {
            dp[0][j + 1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
        }
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                dp[i + 1][j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1) && dp[i][j + 1])
                                || (s2.charAt(j) == s3.charAt(i + j + 1) && dp[i + 1][j]);
            }
        }
        return dp[n1][n2];
    }
}
