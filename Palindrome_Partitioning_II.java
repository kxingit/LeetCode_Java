/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

// Time Limit Exceeded: 28 / 29 test cases passed.
public class Solution {
    public int minCut(String s) {
        // 4:58 - 5:05
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if(isPal(sub)) {
                    if(j == 0) {
                        dp[i] = 0;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
