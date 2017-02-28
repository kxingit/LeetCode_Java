/*
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        // 11:54 - 12:36
        HashMap<Character, String> map = new HashMap();
        String[] words = str.split("\\s+");
        System.out.print(Arrays.toString(words));
        if(words.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word)) {
                    return false;
                }
            } else if(map.containsValue(word)){ // !!!
                return false;
            } else {
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
