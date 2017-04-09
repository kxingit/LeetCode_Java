/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/
public class Solution {
    public String reverseWords(String s) {
        // 8:30 - 8:33
        String[] arr = s.split(" ");
        
        StringBuffer res = new StringBuffer();
        for(String word : arr) {
            res.append(reverse(word) + " ");
        }
        return res.substring(0, res.length() - 1).toString();
    }
    
    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while(i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++; j--;
        }
        return new String(chars);
    }
}
