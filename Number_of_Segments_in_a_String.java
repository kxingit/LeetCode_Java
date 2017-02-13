/*
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 */
public class Solution {
    public int countSegments(String s) {
        // 12:41 - 12:44
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                res++;
            }
        }
        return res;
    }
}
