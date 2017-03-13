/*
   Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
   */
// Weekly contest
public class Solution {
    public String reverseStr(String s, int k) {
        char[] res = s.toCharArray();
        int start = 0;
        int end = k - 1 <= s.length() - 1 ? k - 1 : s.length() - 1;
        while(start < s.length()) {
            end = start + k - 1 <= s.length() - 1 ? start + k - 1 : s.length() - 1;;
            int i = start, j = end;
            while(i < j) {
                char tmp = res[i];
                res[i] = res[j];
                res[j] = tmp;
                i++; 
                j--;
            }
            start = start + 2 * k;
        }
        
        return String.valueOf(res);
    }
}
