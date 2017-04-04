/*
Given an array of strings, group anagrams together.
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 3:47 - 3:54
        HashMap<String, List<String>> res = new HashMap();
        for(String s : strs) {
            String label = getLabel(s);
            if(!res.containsKey(label)) {
                res.put(label, new ArrayList());
            }
            res.get(label).add(s);
        }
        
        return new ArrayList(res.values());
    }
    
    public String getLabel(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return new String(sArray);
    }
}
