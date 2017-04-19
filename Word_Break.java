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

// v5 DFS  TLE: 27 / 34 test cases passed.
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 3:35 - 3:45
        for(int i = 0; i < s.length(); i++) {
            if(!wordDict.contains(s.substring(0, i + 1))) continue;
            if(i + 1 == s.length()) return true;
            if(i + 1 < s.length() && wordBreak(s.substring(i + 1, s.length()), wordDict)) return true;
        }
        return false;
    }
}

// v5
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 3:55 - 4:01
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for(int i = 0; i < n; i++) {
            for(String word : wordDict) {
                int len = word.length();
                if(i + 1 >= len && s.substring(i + 1 - len, i + 1).equals(word)) {
                    dp[i + 1] |= dp[i + 1 - len];
                }
            }
        }
        return dp[n];
    }
}

// v6 LTE
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 2:49 - 2:52
        return dfs(s, 0, wordDict);
    }
    
    public boolean dfs(String s, int pos, List<String> dict) {
        if(pos == s.length()) {
            return true;
        }
        
        for(int i = pos; i < s.length(); i++) {
            String next = s.substring(pos, i + 1);
            if(!dict.contains(next)) continue;
            if(dfs(s, i + 1, dict)) return true;
        }
        
        return false;
    }
}

// v7
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 2:53 - 3:11
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        
        for(int i = 0; i < s.length(); i++) {
            for(String w : wordDict) {
                int len = w.length();
                if(i - len + 1 >= 0) {
                    if(w.equals(s.substring(i - len + 1, i + 1))) {
                        dp[i + 1] |= dp[i - len + 1];
                    }
                }
            }
        }
        
        return dp[m];
    }
}

// v8
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 12:06 - 12:10
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // can use word in dict multiple times:
        // for(String w : wordDict) {
        //     for(int i = 0; i < n; i++) {
        //         if(i + 1 >= w.length() && dp[i + 1 - w.length()]) {
        //             if(!w.equals(s.substring(i + 1 - w.length(), i + 1))) continue;
        //             dp[i + 1] = true;
        //         }
        //     }
        // }
        // can only use word in dict once:
        for(int i = 0; i < n; i++) {
            for(String w : wordDict) {
                if(i + 1 >= w.length() && dp[i + 1 - w.length()]) {
                    if(!w.equals(s.substring(i + 1 - w.length(), i + 1))) continue;
                    dp[i + 1] = true;
                }
            }
        }
        return dp[n];
    }
}
