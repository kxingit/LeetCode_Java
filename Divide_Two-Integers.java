/*
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 */
public class Solution {
    // 10:26 - 10:30 - 10:52
    public int divide(int dividend, int divisor) {
        int sign = (long)dividend * divisor > 0 ? 1 : -1;
        long divd = Math.abs((long)dividend); // must abs((long))
        long divsor = Math.abs((long)divisor);
        if(divd < divsor) return 0;
        
        long start = 1, end = divd;
 
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if(mid * divsor >= divd) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(end * divsor <= divd) {
            if(sign * end > Integer.MAX_VALUE || sign * end < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return sign * (int)end;
        }
        else {
            if(sign * start > Integer.MAX_VALUE || sign * start < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return sign * (int)start;
        }
    }
}
