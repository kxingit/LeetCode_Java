/*
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 */
public class Codec {
    // 5:55 - 6:03
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String s : strs) {
            int len = s.length();
            sb.append(len + "#");
            sb.append(s);
        }
        return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> res = new ArrayList();
        while(i < s.length()) {
            int j = i;
            for(; j < s.length(); j++) {
                if(s.charAt(j) == '#') {
                    break;
                }
            }
            int len = Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j + 1, j + len + 1));
            i = j + len + 1;
        }
        
        return res;
    }
}

// v2
public class Codec {
    // 9:27 - 9:31
 
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String s : strs) {
            int len = s.length();
            sb.append(len + "#" + s);
        }
        return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList();
        
        int i = 0;
        while(i < s.length()) {
            int j = i;
            for(; j < s.length(); j++) {
                if(s.charAt(j) == '#') {
                    break;
                }
            }
            int len = Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j + 1, j + 1 + len));
            i = j + len + 1;
        }
        
        return res;
    }
}
