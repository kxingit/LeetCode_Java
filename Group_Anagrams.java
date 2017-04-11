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
        
        return new ArrayList(res.values()); // shortcut
    }
    
    public String getLabel(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return new String(sArray);
    }
}

// v2
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 11:52 - 11:56
        Map<String, List<String>> map = new HashMap();
        for(String s : strs) {
            String label = genLabel(s);
            if(map.containsKey(label) == false) {
                map.put(label, new ArrayList());
            }
            map.get(label).add(s);
        }
         
        List<List<String>> res = new ArrayList();
        for(String label : map.keySet()) {
            res.add(map.get(label));
        }
         
        return res;
    }
     
    public String genLabel(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
