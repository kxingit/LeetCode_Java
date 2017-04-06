/*
Implement pow(x, n).
*/
public class Solution {
    public double myPow(double x, int n) {
        // 4:54 - 4:57 - 5:00 // Integer.MIN_VALUE flip sign overflow
        if(n == 0) return 1;
        if(n == 1) return x;
        
        long longn = (long) n;
        int sign = 1;
        if(longn < 0) {
            longn = -longn;
            sign = -1;
        }
        
        double res = 1;
        
        double half = myPow(x, (int)(longn / 2));
        if(n % 2 == 0) {
            res = half * half;
        } else {
            res = half * half * x;
        }
        
        return sign > 0 ? res : 1. / res;
    }
}
