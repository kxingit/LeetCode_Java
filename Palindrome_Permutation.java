/*
 * Given a string, determine if a permutation of the string could form a palindrome.
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        // 2:58 - 3:01
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int nodd = 0;
        for(Character c : map.keySet()) {
            if(map.get(c) % 2 == 1) nodd++;
        }
        
        return nodd == 0 || nodd == 1;
    }
}
