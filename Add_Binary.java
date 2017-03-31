/*
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

public class Solution {
    public String addBinary(String a, String b) {
        // 10:38 - 10:47
        int i = a.length() - 1, j = b.length() - 1;
        StringBuffer res = new StringBuffer();
        
        int carry = 0;
        while(i >= 0 && j >= 0) {
            int acurr = Character.getNumericValue(a.charAt(i--));
            int bcurr = Character.getNumericValue(b.charAt(j--));
            int curr = acurr + bcurr + carry;
            System.out.print(curr);
            carry = curr / 2;
            curr %= 2;
            res.insert(0, (char)(curr + '0'));
        }
        
        while(i >= 0) {
            int acurr = Character.getNumericValue(a.charAt(i--));
            int curr = acurr  + carry;
            carry = curr / 2;
            curr %= 2;
            res.insert(0, (char)(curr + '0'));
        }
        
        while(j >= 0) {
            int bcurr = Character.getNumericValue(b.charAt(j--));
            int curr = bcurr  + carry;
            carry = curr / 2;
            curr %= 2;
            res.insert(0, (char)(curr + '0'));
        }
        
        if(carry > 0) {
            res.insert(0, '1');
        }
        
        if(res.charAt(0) == '0') return "0";
        
        return res.toString();
    }
}
