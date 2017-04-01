/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */

public class Solution {
    public int numDecodings(String s) {
        // 4:48 - 4:51
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i <= n; i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}

// v2
public class Solution {
    public int numDecodings(String s) {
        // 11:10 - 11:13
        int n = s.length();
        if(n == 0) return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i <= n; i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            int twoDigits = (s.charAt(i - 1) - '0') + (s.charAt(i - 2) - '0') * 10;
            if(twoDigits >= 10 && twoDigits <= 26) { // "=="
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}
