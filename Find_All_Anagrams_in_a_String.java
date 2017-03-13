/*
   Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

   Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

   The order of output does not matter.
   */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 8:56 - 9:02 - 9:09
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        if(p.length() > s.length()) return new ArrayList();
        for(int i = 0; i < p.length(); i++) {
            count1[s.charAt(i) - 'a']++;
            count2[p.charAt(i) - 'a']++;
        }
        
        List<Integer> res = new ArrayList();
        
        for(int i = 0; i < s.length() - p.length() + 1; i++) {
            if(isAna(count1, count2)) {
                res.add(i);
            }
            if(i == s.length() - p.length()) break;
            count1[s.charAt(i) - 'a']--;
            count1[s.charAt(i + p.length()) - 'a']++;
        }
        
        return res;
    }
    private boolean isAna(int[] c1, int c2[]) {
        for(int i = 0; i < 26; i++) {
            if(c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
