/*
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        // 3:22 - 3:36 - 4:22
        int res = 0;
        HashMap<Character, Integer> map_cnt = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map_cnt.put(c, map_cnt.getOrDefault(c, 0) + 1);
        }
        // get saparaters. val = -1
        boolean hasSep = false;
        for(Character c : map_cnt.keySet()) {
            if(map_cnt.get(c) < k) {
                map_cnt.put(c, -1); 
                hasSep = true;
            }
        }
        if(!hasSep) return s.length();
        int start = 0, end = 0;
        while(start < s.length() && end <= s.length()) {
            if(end == s.length() || map_cnt.get(s.charAt(end)) == -1) {
                String sub = s.substring(start, end);
                res = Math.max(res, longestSubstring(sub, k));
                start = end + 1;
                end++;
            } else if(start == end && map_cnt.get(s.charAt(end)) == -1) {
                    start++; end++;
            } else {
                end++;
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int longestSubstring(String s, int k) {
        // 3:22 - 3:36 - 4:22
        int res = 0;
        HashMap<Character, Integer> map_cnt = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map_cnt.put(c, map_cnt.getOrDefault(c, 0) + 1);
        }
        // get saparaters. val = -1
        boolean hasSep = false;
        for(Character c : map_cnt.keySet()) {
            if(map_cnt.get(c) < k) {
                map_cnt.put(c, -1); 
                hasSep = true;
            }
        }
        if(!hasSep) return s.length();
        int start = 0, end = 0;
        while(start < s.length() && end <= s.length()) {
            if(end == s.length() || map_cnt.get(s.charAt(end)) == -1) {
                String sub = s.substring(start, end);
                res = Math.max(res, longestSubstring(sub, k));
                start = end + 1;
            } else if(start == end && map_cnt.get(s.charAt(end)) == -1) {
                    start++;
            }
            end++;
        }
        return res;
    }
}
