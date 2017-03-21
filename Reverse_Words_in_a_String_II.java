/*
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 *
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 */
public class Solution {
    public void reverseWords(char[] s) {
        // 12:07 - 12:20
        int l = 0, r = 0;
        int n = s.length;
        int i = 0;
        while(i < n) {
            if(i == 0 || s[i - 1] == ' ') {
                l = i;
                r = i;
                while(r + 1 < n && s[r + 1] != ' ') {
                    r++;
                }
                reverse(s, l, r);
            }
            i = r + 1;
            while(i < n && s[i] == ' ') i++;
        }
        reverse(s, 0, s.length - 1);
    }
    
    public void reverse(char[] s, int i, int j) {
        while(i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
