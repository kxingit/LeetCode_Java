/*
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 */
public class Solution {
    public String[] findWords(String[] words) {
        // 5:49 - 6:25
        HashMap<Character, Integer> map = new HashMap();
        String first = "qwertyuiopQWERTYUIOP";
        String second = "asdfghjklASDFGHJKL";
        String third = "zxcvbnmZXCVBNM";
        for(int i = 0; i < first.length(); i++) map.put(first.charAt(i), 1);
        for(int i = 0; i < second.length(); i++) map.put(second.charAt(i), 2);
        for(int i = 0; i < third.length(); i++) map.put(third.charAt(i), 3);
        List<String> res = new ArrayList();
        for(int i = 0; i < words.length; i++) {
            if(isGood(words[i], map)) res.add(words[i]);
        }
        int n = res.size();
        // String[] result = new String[n];
        // for(int i = 0; i < n; i++) {
        //     result[i] = res.get(i);
        // }
        // return result;
        return res.toArray(new String[n]);
    }
    private boolean isGood(String s, HashMap map) {
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != map.get(s.charAt(0))){
                return false;
            } 
        }
        return true;
    }
}

// v2
public class Solution {
    private HashMap<Character, Integer> map = new HashMap();
    
    public String[] findWords(String[] words) {
        // 9:35 - 9:58
        String first = "qwertyuiopQWERTYUIOP";
        String second = "asdfghjklASDFGHJKL";
        String third = "zxcvbnmZXCVBNM";
        
        for(int i = 0; i < first.length(); i++) {
            map.put(first.charAt(i), 1);
        }
        for(int j = 0; j < second.length(); j++) {
            map.put(second.charAt(j), 2);
        }
        for(int k = 0; k < third.length(); k++) {
            map.put(third.charAt(k), 3);
        }
        
        List<String> res = new ArrayList();
        for(int i = 0; i < words.length; i++) {
            if(isGood(words[i])) res.add(words[i]);
        }
        return res.toArray(new String[res.size()]);
    }
    
    private boolean isGood(String w) {
        for(int i = 0; i < w.length(); i++) {
            if(map.get(w.charAt(i)) != map.get(w.charAt(0))) {
                return false;
            }
        }
        return true;
    }
}
