/*
Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.
*/
// wrong for "11"
public class Solution {
    public String nearestPalindromic(String n) {
        // 9:20 - 9:51
        int len = n.length();
        if(len == 1) {
            return "" + (n.charAt(0) - '0' - 1);
        }

        StringBuffer res = new StringBuffer();
        StringBuffer firstHalf = new StringBuffer();
        StringBuffer secondHalf = new StringBuffer();
        
        if(n.charAt(0) == '1') {
            boolean is10like = true;
            for(int i = 1; i < len; i++) {
                if(n.charAt(i) != '0') {
                    is10like = false;
                }
            }
            if(is10like) {
                for(int i = 0; i < len - 1; i++) {
                    res.append(9);
                }
                return res.toString();
            }
        }
        
        for(int i = 0; i < len / 2; i++) {
            res.append(n.charAt(i));
            firstHalf.append(n.charAt(i));
            secondHalf.insert(0, n.charAt(i));
        }
        if(len % 2 == 1) {
            res.append(n.charAt(len / 2));
        }
        res.append(secondHalf);
        if(!res.toString().equals(n)) {
            return res.toString();
        } else {
            if(len % 2 == 1) {
                int mid = n.charAt(len / 2) - '0';
                if(mid == 0) {
                    mid++;
                } else {
                    mid--;
                }
                firstHalf.append(mid);
                firstHalf.append(secondHalf);
                return firstHalf.toString();
            } else {
                int mid = n.charAt(len / 2 - 1) - '0';
                if(mid == 0) {
                    mid++;
                } else {
                    mid--;
                }
                firstHalf.setCharAt(firstHalf.length() - 1, (char)('0' + mid));
                secondHalf.setCharAt(0, (char)('0' + mid));
                firstHalf.append(secondHalf);
                return firstHalf.toString();
            }
        }
    }
}
