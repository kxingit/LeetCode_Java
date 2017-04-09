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

// v2
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 2:56 -3:02
        List<Integer> res = new ArrayList();
        
        int[] count = new int[26];
        int[] pcount = new int[26];
        int k = p.length();
        int len = 0;
        int l = 0;
        
        for(int i = 0; i < p.length(); i++) {
            pcount[p.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            len++;
            count[s.charAt(i) - 'a']++;
            if(len > k) {
                count[s.charAt(l++) - 'a']--;
            }
            if(isAna(count, pcount)) {
                res.add(l);
            }
        }
        
        return res;
    }
    
    public boolean isAna(int[] c1, int[] c2) {
        for(int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) return false;
        }
        return true;
    }
}
