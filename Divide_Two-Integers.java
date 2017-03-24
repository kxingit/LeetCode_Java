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

// v2
public class Solution {
    public int divide(int dividend, int divisor) {
        // 9:36 - 9:42 - 9:46
        long sign = (long)dividend * (long)divisor > 0 ? 1 : -1;
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        
        long start = 0, end = d1; // starts from 0
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if(d2 * mid <= d1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(end * d2 <= d1) {
            if(end * sign > Integer.MAX_VALUE || end * sign < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)end * (int)sign;
        } else {
            if(start * sign > Integer.MAX_VALUE || start * sign < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)start * (int)sign;
        }
    }
}
