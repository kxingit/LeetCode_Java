/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution {
    HashMap<Character, Integer> counts = new HashMap<>();
    public String minWindow(String s, String t) {
        // 9:38 - 9:48
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) - 1);
        }
        
        int l = 0, r = 0;
        counts.put(s.charAt(0), counts.getOrDefault(s.charAt(0), 0) + 1);
        String res = "";
        if(s.length() == 0) return res;
        while(l < s.length() && r < s.length()) {
            if(isCover(counts)) {
                if(res.equals("") || res.length() > r - l + 1) {
                    res = s.substring(l, r + 1);
                }
                counts.put(s.charAt(l), counts.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            } else {
                r++;
                if(r < s.length()) {
                    counts.put(s.charAt(r), counts.getOrDefault(s.charAt(r), 0) + 1); // >= 0 cover typo
                } else {
                    break;
                }
            }
        }
        
        return res;
    }
    
    public boolean isCover(HashMap<Character, Integer> counts) {
        for(Character c : counts.keySet()) {
            if(counts.get(c) < 0) return false;
        }
        
        return true;
    }
}
