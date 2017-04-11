/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */

// Time Limit Exceeded: 94 / 94 test cases passed.
public class Solution {
    public String longestPalindrome(String s) {
        // 11:25 - 11:38
        int n = s.length();
        String res = "";
        if(n == 0) return res;
        
        for(int k = 0; k < n; k++) {
            int i = k, j = k;
            while(i >= 0 && j < n) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(res.length() < j + 1 - i) {
                        res = s.substring(i, j + 1);
                    }
                } else {
                    break;
                }
                i--; j++;
            }
            i = k; j = k + 1;
            while(i >= 0 && j < n) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(res.length() < j + 1 - i) {
                        res = s.substring(i, j + 1);
                    }
                } else {
                    break;
                }
                i--; j++;
            }
        }
        return res;
    }
}

// O(n): Manacher's 
public class Solution {
    public String longestPalindrome(String s) {
        // from wiki， Manacher's algorithm
        if (s==null || s.length()==0)
            return "";
        
        char[] s2 = addBoundaries(s.toCharArray());
        int[] p = new int[s2.length]; 
        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same
        for (int i = 1; i<s2.length; i++) {
            if (i>r) {
                p[i] = 0; m = i-1; n = i+1;
            } else {
                int i2 = c*2-i;
                if (p[i2]<(r-i)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below. 
                } else {
                    p[i] = r-i;
                    n = r+1; m = i*2-n;
                }
            }
            while (m>=0 && n<s2.length && s2[m]==s2[n]) {
                p[i]++; m--; n++;
            }
            if ((i+p[i])>r) {
                c = i; r = i+p[i];
            }
        }
        int len = 0; c = 0;
        for (int i = 1; i<s2.length; i++) {
            if (len<p[i]) {
                len = p[i]; c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c-len, c+len+1);
        return String.valueOf(removeBoundaries(ss));
    }
 
    private static char[] addBoundaries(char[] cs) {
        if (cs==null || cs.length==0)
            return "||".toCharArray();
 
        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }
 
    private static char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();
 
        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }   
}

// v3
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for(int k = 0; k < n; k++) {
            int i = k, j = k;
            while(i >= 0 && j < n) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(res.length() < j + 1 - i)
                        res = s.substring(i, j + 1);
                } else {
                    break;
                }
                i--; j++;
            }
        }
        for(int k = 0; k < n; k++) {
            int i = k, j = k + 1;
            while(i >= 0 && j < n) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(res.length() < j + 1 - i)
                        res = s.substring(i, j + 1);
                }else {
                    break;
                }
                i--; j++;
            }
        }
        return res;
    }
}

// v4
public class Solution {
    public String longestPalindrome(String s) {
        // 8:09 - 8:17 - 8:55
        int n = s.length();
        String res = "";
        for(int i = 0; i < n; i++) {
            String evenpal = evenPal(s, i);
            if(evenpal.length() > res.length()) {
                res = evenpal;
            }
            String oddpal = oddPal(s, i);
            if(oddpal.length() > res.length()) {
                res = oddpal;
            }
        }
        return res;
    }
    
    public String evenPal(String s, int mid) {
        int i = mid, j = mid + 1;
        int len = 0;
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                len++;
            } else {
                break;
            }
            i--; j++;
        }
        if(len == 0) return "";
        return s.substring(mid + 1 - len, mid + len + 1);
    }
    
    public String oddPal(String s, int mid) {
        int i = mid - 1, j = mid + 1;
        int len = 0;
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                len++;
            } else {
                break;
            }
            i--; j++;
        }
        if(len == 0) return s.substring(mid, mid + 1);
        return s.substring(mid - len, mid + len + 1);
    }
}

// v5
public class Solution {
    public String longestPalindrome(String s) {
        // 8:57 - 9:05
        String res = "";
        for(int k = 0; k < s.length(); k++) {
            int i = k, j = k;
            while(i >= 0 && j < s.length()) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                } else {
                    break;
                }
                i--; j++;
            }
            
            i = k;
            j = k + 1;
            while(i >= 0 && j < s.length()) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                } else {
                    break; // !!
                }
                i--; j++;
            }
        }
        
        return res;
    }
}
