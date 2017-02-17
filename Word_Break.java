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
