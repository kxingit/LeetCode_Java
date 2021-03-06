/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        // 6:00 - 6:07
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; // MD from first'm' char from word1 and first 'n' char from word2
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])); 
                    }
                }
            }
        }
        return dp[m][n];
    }
}

// v2
public class Solution {
    public int minDistance(String word1, String word2) {
        // 9:29 - 9:34
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));   
                    }
                }
            }
        }
        return dp[m][n];
    }
}
