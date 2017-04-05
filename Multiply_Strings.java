/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
*/
public class Solution {
    public String multiply(String num1, String num2) {
        // 1:31 - 1:51
        int n1 = num1.length(), n2 = num2.length();
        int n = n1 + n2;
        int[] res = new int[n];
        
        for(int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            for(int j = n2 - 1; j >= 0; j--) {
                int curr = carry + res[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j + 1] = curr % 10;
                carry = curr / 10;
            }
            res[i] = carry;
        }
        
        int i = 0;
        while(i < n - 1 && res[i] == 0) {
            i++;
        }
        
        StringBuffer sb = new StringBuffer();
        for(; i < n; i++) {
            sb.append(res[i]);
        }
        
        return sb.toString();
    }
}

// v2
public class Solution {
    public String multiply(String num1, String num2) {
        // 9:25 - 9:30
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        
        for(int i = m - 1; i >= 0; i--) {
            int carry = 0;
            for(int j = n - 1; j >= 0; j--) {
                int curr = res[i + j + 1] + carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                carry = curr / 10;
                curr %= 10;
                res[i + j + 1] = curr; // !!
            }
            res[i] = carry;
        }
        
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i < res.length - 1 && res[i] == 0) i++;
        
        for(int ii = i; ii < res.length; ii++) {
            sb.append(res[ii]);
        }
        
        return sb.toString();
    }
}
