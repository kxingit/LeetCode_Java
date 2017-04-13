/*
Reverse digits of an integer.
*/
public class Solution {
    public int reverse(int x) {
        // 11:47 - 11:53
        int sign = x > 0 ? 1 : -1;
        long num = (long)x * sign;
        long res = 0;
        while(num > 0) {
            long lastDigit = num % 10;
            num = num / 10;
            res = res * 10 + lastDigit;
        }
        
        return res * sign > Integer.MAX_VALUE || res*sign < Integer.MIN_VALUE ? 0 : (int)(res * sign);
    }
}
