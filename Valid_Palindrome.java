/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        // 11:01 - 11:09
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(!isValChar(s, i)) {
                i++;
                continue;
            }
            if(!isValChar(s, j)) {
                j--;
                continue;
            }
            if(!isSame(s, i, j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
    private boolean isValChar(String s, int i) {
        if(Character.isLetter(s.charAt(i))) return true;
        if(Character.isDigit(s.charAt(i))) return true;
        return false;
    }
    private boolean isSame(String s, int i, int j) {
        return Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j));
    }
}
