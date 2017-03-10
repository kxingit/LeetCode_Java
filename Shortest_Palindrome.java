/*
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 */
public class Solution {
    public String shortestPalindrome(String s) {
        // 4:15 - 4:27
        int n = s.length();
        if(n == 0) return "";
        int l = 0, r = n - 1, end = n - 1;
        char[] ch = s.toCharArray();
        while(l < r) {
            if(ch[l] == ch[r]) {
                l++; r--;
            } else {
                l = 0;
                end--;
                r = end;
            }
        }
        StringBuffer sb = new StringBuffer(s.substring(end + 1));
        return sb.reverse().toString() + s;
    }
}
