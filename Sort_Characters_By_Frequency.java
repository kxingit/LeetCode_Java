/*
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charFreqMap = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList(charFreqMap.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character, Integer> e : list) {
            for(int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}

// v2
public class Solution {
    public String frequencySort(String s) {
        // 11:45 - 11:50
        HashMap<Character, Integer> charCountMap = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList(charCountMap.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); // compareTo?
            }
        });
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).getValue(); j++) {
                sb.append(list.get(i).getKey());
            }
        }
        return sb.toString();
    }
}

// v3
public class Solution {
    public String frequencySort(String s) {
        // 11:45
        HashMap<Character, Integer> charCountMap = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList(charCountMap.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).getValue(); j++) {
                sb.append(list.get(i).getKey());
            }
        }
        return sb.toString();
    }
}
