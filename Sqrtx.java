/*
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 */
public class Solution {
    public int mySqrt(int x) {
        // 4:32 - 4:34
        int start = 1, end = x;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if((long)mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(end * end == x) return end;
        else return start;
    }
}
