/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 3:45 - 4:36
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= i; j++) {
                String sub = s.substring(j - 1, i - 1 + 1);
                if(wordDict.contains(sub)) {
                    dp[i] |= dp[j - 1];
                }
            }
        }
        return dp[m];
    }
}

// v2
// This does not work because string has order, i.e. s1 + s2 + s1 can never be achieved.
// while sum does not have order, i.e. 1 + 2 + 1 = 1 + 1 + 2 (use 1 multiple times)
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 3:30
        int m = s.length(), n = wordDict.size();
        boolean[][] dp = new boolean[n + 1][m + 1]; // first 'm' substring can be broken with first 'n' in dict
        for(int i = 0; i < n + 1; i++) dp[i][0] = true;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                int ilen = wordDict.get(i).length();
                if(j >= ilen) {
                    String sub = s.substring(j - ilen, j);
                    dp[i + 1][j] = dp[i][j] || (dp[i][j - ilen] && wordDict.get(i).equals(sub));
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        return dp[n][m];
    }
}


// v3
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 4:07 - 4:13
        int m = s.length(), n = wordDict.size();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                String word = wordDict.get(j);
                int ilen = word.length();
               if(i >= ilen) {
                   String sub = s.substring(i - ilen, i);
                   dp[i] |= sub.equals(word) && dp[i - ilen];
               }
            }
        }
        return dp[m];
    }
}

// v4
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 10:00 - 10:13
        int m = s.length(), n = wordDict.size();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                String word = wordDict.get(j);
                int len = word.length();
                if(i >= len && word.equals(s.substring(i - len, i))) { // java substring: [start, end)
                    dp[i] |= dp[i - len];
                }
            }
        }
        return dp[m];
    }
}
