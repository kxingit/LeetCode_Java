/*
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 */
public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        // 12:08 - 12:20
        for(int ilen = 1; ilen <= str.length() / 2; ilen++) {
            String substring = str.substring(0, ilen);
            for(int i = 0; i <= str.length(); i = i + ilen) {
                if(!isMatch(str, substring, i)) break;
                if(i +  ilen == str.length()) return true;
            }
        }
        return false;
    }
    private Boolean isMatch(String str, String sub, int start) {
        for(int i = 0; i < sub.length(); i++) {
            if(start + i >= str.length()) return false;
            if(str.charAt(start + i) != sub.charAt(i)) return false;
        }
        return true;
    }
}

// v2
public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        // 12:08 - 12:25
        for(int ilen = 1; ilen <= str.length() / 2; ilen++) {
            if(str.length() % ilen != 0) continue; // optimization
            String substring = str.substring(0, ilen);
            for(int i = 0; i <= str.length(); i = i + ilen) {
                if(!isMatch(str, substring, i)) break;
                if(i +  ilen == str.length()) return true;
            }
        }
        return false;
    }
    private Boolean isMatch(String str, String sub, int start) {
        for(int i = 0; i < sub.length(); i++) {
            if(start + i >= str.length()) return false;
            if(str.charAt(start + i) != sub.charAt(i)) return false;
        }
        return true;
    }
}
