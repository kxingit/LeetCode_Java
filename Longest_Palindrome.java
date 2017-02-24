/*
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */
public class Solution {
    public int longestPalindrome(String s) {
        // 2:17 - 2:22
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int res = 0;
        for(Character c : map.keySet()) {
            int count = map.get(c);
            int newcount = count % 2;
            res += count - newcount;
            map.put(c, newcount);
        }
        for(Character c : map.keySet()) {
            if(map.get(c) == 1) {
                res++;
                break;
            }
        }
        return res;
    }
}
