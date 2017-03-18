/*
   Given a string, find the length of the longest substring T that contains at most k distinct characters.

   For example, Given s = “eceba” and k = 2,

   T is "ece" which its length is 3.
   */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // 3:48 - 3:54
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap();
        int l = 0;
        int res = 0;
        for(int r = 0; r < n; r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k) {
                char leftc = s.charAt(l);
                map.put(leftc, map.get(leftc) - 1);
                if(map.get(leftc) == 0) {
                    map.remove(leftc);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
