/*
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        // 5:01 - 5:11
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuffer res = new StringBuffer();
        while(i >= 0 || j >= 0) {
            int x, y;
            if(i < 0) {
                x = 0;
                y = num2.charAt(j) - '0';
            } else if(j < 0) {
                y = 0;
                x = num1.charAt(i) - '0';
            } else {
                x = num1.charAt(i) - '0';
                y = num2.charAt(j) - '0';
            }
            int curr = x + y + carry;
            carry = curr / 10;
            curr = curr % 10;
            res.insert(0, (char)('0' + curr));
            i--; j--;
        }
        if(carry > 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }
}

// v2
public class Solution {
    public String addStrings(String num1, String num2) {
        // 5:01 - 5:11 - 5:13
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuffer res = new StringBuffer();
        while(i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int curr = x + y + carry;
            carry = curr / 10;
            curr = curr % 10;
            res.insert(0, (char)('0' + curr));
            i--; j--;
        }
        if(carry > 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }
}
