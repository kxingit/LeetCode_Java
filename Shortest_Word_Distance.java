/*
   Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
   */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // 9:27 - 9:33
        int i1 = -1, i2 = -1;
        int n = words.length;
        int res = n;
        for(int i = 0; i < n; i++) {
            if(word1.equals(words[i])) {
                i1 = i;
            }
            if(word2.equals(words[i])) {
                i2 = i;
            }
            if(i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        
        return res;
    }
}

// v2
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // 10:25 - 10:29
        int i1 = -1, i2 = -1;
        int res = words.length;
        for(int i = 0; i < words.length; i++) {
            if(word1.equals(words[i])) {
                i1 = i;
            }
            if(word2.equals(words[i])) {
                i2 = i;
            }
            if(i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        
        return res;
    }
}
