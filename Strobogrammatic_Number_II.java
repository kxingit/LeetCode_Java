/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 */

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        // 6:18 - 6:25 - 6:37
        List<String> res = new ArrayList();
        List<String> cand = helper(n);
        for(String s : cand) {
            if(s.length() > 0 && s.charAt(0) != '0') {
                res.add(s);
            }
            if(s.equals("0")) res.add(s);
        }
        
        return res;
    }
    
    public List<String> helper (int n) {
        List<String> res = new ArrayList();
        if(n == 0) {
            res.add("");
            return res;
        }
        if(n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        
        List<String> shorterStrobs = helper(n - 2); // helper, not findStrobogrammatic
        for(String s : shorterStrobs) {
            List<String> expendeds = expend(s);
            for(String exp : expendeds) {
                res.add(exp);
            }
        }
        
        return res;
    }
    
    public List<String> expend(String s) {
        List<String> res = new ArrayList();
        res.add("0" + s + '0');
        res.add("1" + s + '1');
        res.add("6" + s + '9');
        res.add("8" + s + '8');
        res.add("9" + s + '6');
        return res;
    }
}
