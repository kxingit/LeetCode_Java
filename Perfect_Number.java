/*
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
*/
public class Solution {
    public boolean checkPerfectNumber(int num) {
        // 6:31 - 6:33 - 6:43
        if(num <= 0) return false;
        
        int res = 0;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i != 0) continue;
            if(i != 1) {
                res += i + num / i;
            } else {
                if(i < num) res += 1;
            }
        }
        
        int i = (int)Math.sqrt(num);
        if(i < num && i * i == num) {
            res += i;
        }
        
        return res == num;
    }
}
