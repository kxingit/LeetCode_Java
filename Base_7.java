/*
 * Given an integer, return its base 7 string representation.
 */
public class Solution {
    public String convertToBase7(int num) {
        // 11:41 - 1:48
        if(num == 0) return "0";
        StringBuffer res = new StringBuffer();
        int sign = num < 0 ? -1 : 1;
        num = Math.abs(num);
        while(num > 0) {
            res.insert(0, (char)(num % 7 + '0'));
            num = num / 7;
        }
        if(sign < 0) res.insert(0, "-");
        return res.toString();
    }
}

// v2
public class Solution {
    public String convertToBase7(int num) {
        // 9:23 - 9:25
        int sign = num < 0 ? -1 : 1;
        num = Math.abs(num);
        if(num == 0) return "0";
        StringBuffer res = new StringBuffer();
        while(num > 0) {
            res.insert(0, (char)(num % 7 + '0'));
            num = num / 7;
        }
        if(sign < 0) {
            res.insert(0, '-');
        }
        
        return res.toString();
    }
}
