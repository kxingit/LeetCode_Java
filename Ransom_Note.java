/*
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 11:06 - 11:09
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        for(int i = 0; i < ransomNote.length(); i++) { // ransom??
            char c = ransomNote.charAt(i);
            if(map.containsKey(c) == false || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}

// v2
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
