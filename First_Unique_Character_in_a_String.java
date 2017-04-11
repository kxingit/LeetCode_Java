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

// v2
public class Solution {
    public int firstUniqChar(String s) {
        // 9:59 - 10:00
        HashMap<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
