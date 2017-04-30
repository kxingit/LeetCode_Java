/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.*/
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 9:04 - 9:07
        // not checking substring
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(char c : s1.toCharArray()) {
        //     map.put(c, 1 + map.getOrDefault(c, 0));
        // }
        
        // for(char c : s2.toCharArray()) {
        //     map.put(c, 1 + map.getOrDefault(c, 0) - 1);
        //     if(map.get(c) < 0) {
        //         return false;
        //     }
        // }
        
        // return true;
        
        // LTE
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()) {
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        
        for(int i = 0; i < s2.length(); i++) {
            HashMap<Character, Integer> tmpmap = (HashMap)map.clone();
            if(i + s1.length() > s2.length()) return false; 
            for(int j = i; j < i + s1.length(); j++) {
                char c = s2.charAt(j);
                tmpmap.put(c, tmpmap.getOrDefault(c, 0) - 1);
                if(tmpmap.get(c) < 0) break;
                if(j == i + s1.length() - 1) return true;
            }
        }
        
        return false;
    }
}
