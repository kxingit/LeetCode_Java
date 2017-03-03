/* 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 */
public class Solution {
    public int firstUniqChar(String s) {
        // 12:16 - 12:20
        HashMap<Character, Integer> map_cnt = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map_cnt.put(c, 1 + map_cnt.getOrDefault(c, 0));
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map_cnt.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
