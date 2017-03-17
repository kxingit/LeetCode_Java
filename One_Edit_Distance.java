/*
   Given two strings S and T, determine if they are both one edit distance apart.
   */
// LTE: 125 / 131 test cases passed.
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // 9:32 - 9:59
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if(i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n] == 1;
    }
}

// v2
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // 10:02 - 10:10
        int m = s.length(), n = t.length();
        if(m == 0) return n == 1;
        if(n == 0) return m == 1;
        if(m == n) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        } else if(m + 1 == n) {
            int i = 0;
            for(; i < m; i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    break;
                }
            }
            if(i == n || s.substring(i).equals(t.substring(i + 1))) {
                return true;
            }
        } else if(n + 1 == m) {
            int i = 0;
            for(; i < n; i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    break;
                }
            }
            if(i == m || s.substring(i + 1).equals(t.substring(i))) {
                return true;
            }
        } 
        return false;
    }
}
