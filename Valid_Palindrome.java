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

// v2
public class Solution {
    public boolean isPalindrome(String s) {
        // 4:47 - 4:52 - 5:59 Character.isLetterOrDight(c) Character.toUpperCase(c)
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(Character.isLetterOrDigit(s.charAt(l)) == false) {
                l++;  
            } else if(Character.isLetterOrDigit(s.charAt(r)) == false) {
                r--;
            } else {
                if(Character.toUpperCase(s.charAt(l)) != Character.toUpperCase(s.charAt(r))) {
                    return false;
                }
                l++; r--; // !!
            }
        }
        return true;
    }
}

// v3
public class Solution {
    public boolean isPalindrome(String s) {
        // 12:32 - 12:35
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
