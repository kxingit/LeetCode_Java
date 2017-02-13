/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */

public class Solution {
    public String reverseVowels(String s) {
        // 12:15 - 12:34
        int n = s.length();
        int start = 0, end = n - 1;
        StringBuilder sb = new StringBuilder(s);
        while(start < end) {
            if(!isV(s, start)) {
                start++;
                continue;
            }
            if(!isV(s, end)) {
                end--;
                continue;
            }
            sb.setCharAt(start, s.charAt(end));
            sb.setCharAt(end, s.charAt(start));
            start++;
            end--;
        }
        return sb.toString();
    }
    private boolean isV(String s, int i) {
        return s.charAt(i) == 'a' || s.charAt(i) == 'o' || s.charAt(i) == 'e' || s.charAt(i) == 'u' || s.charAt(i) == 'i' || s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'E' || s.charAt(i) == 'U' || s.charAt(i) == 'I';
    }
}

// v2
public class Solution {
    public String reverseVowels(String s) {
        // 12:15 - 12:19
        int n = s.length();
        int start = 0, end = n - 1;
        char[] res = s.toCharArray();
        while(start < end) {
            if(!isV(s, start)) {
                start++;
                continue;
            }
            if(!isV(s, end)) {
                end--;
                continue;
            }
            res[start] = s.charAt(end);
            res[end]= s.charAt(start);
            start++;
            end--;
        }
        return String.valueOf(res);
    }
    private boolean isV(String s, int i) {
        return s.charAt(i) == 'a' || s.charAt(i) == 'o' || s.charAt(i) == 'e' || s.charAt(i) == 'u' || s.charAt(i) == 'i' || s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'E' || s.charAt(i) == 'U' || s.charAt(i) == 'I';
    }
}

// v3
public class Solution {
    public String reverseVowels(String s) {
        // 12:15 - 12:19
        int n = s.length();
        int start = 0, end = n - 1;
        char[] res = s.toCharArray();
        while(start < end) {
            if(!isV(s, start)) {
                start++;
                continue;
            }
            if(!isV(s, end)) {
                end--;
                continue;
            }
            res[start] = s.charAt(end);
            res[end]= s.charAt(start);
            start++;
            end--;
        }
        return new String(res);
    }
    private boolean isV(String s, int i) {
        return s.charAt(i) == 'a' || s.charAt(i) == 'o' || s.charAt(i) == 'e' 
        || s.charAt(i) == 'u' || s.charAt(i) == 'i' || s.charAt(i) == 'A' 
        || s.charAt(i) == 'O' || s.charAt(i) == 'E' || s.charAt(i) == 'U' || s.charAt(i) == 'I';
    }
}
