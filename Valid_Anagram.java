/*
Given two strings s and t, write a function to determine if t is an anagram of s.
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        // 2:44 - 2:45
        return genLabel(s).equals(genLabel(t));
    }
    
    public String genLabel(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
