/*
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 */

// Time Limit Exceeded:  7 / 67 test cases passed.
class Solution {
public:
    bool isPerfectSquare(int num) {
        // 11:37
        int i = 0;
        while(i * i <= num) {
            if(i * i == num) return true;
            i++;
        }
        return false;
    }
};

// v2
public class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1, end = (int)Math.sqrt(Integer.MAX_VALUE);
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(mid * mid > num) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start * start == num || end * end == num;
    }
}

// v3
public class Solution {
    public boolean isPerfectSquare(int num) {
        for(int i = 1; i <= num / i; i++) {
            if(i * i == num) return true;
        }
        return false;
    }
}

// v4
public class Solution {
    public boolean isPerfectSquare(int num) {
        // 12:09 - 12:11
        int start = 1, end = num;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            long mid2 = (long)mid * mid;
            if(mid2 > num) {
                end = mid;
            } else if(mid2 < num) {
                start = mid;
            } else {
                return true;
            }
        }
        return start * start == num || end * end == num;
    }
}

// v5
public class Solution {
    public boolean isPerfectSquare(int num) {
        // 10:12 - 10:18
        int i = 1;
        long i2 = 1;
        while((long) i * i <= num) { // prevent overflow!!
            if((long) i * i == num) return true;
            i++;
        }
        return false;
    }
}

// v6
public class Solution {
    public boolean isPerfectSquare(int num) {
        return num == (int)Math.sqrt(num) * Math.sqrt(num);
    }
}
