/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 */
public class Solution {
    public int addDigits(int num) {
        // 3:45 - 3:46
        while(num > 9) {
            int newnum = 0;
            while(num > 0) {
                newnum += num % 10;
                num = num / 10;
            }
            num = newnum;
        }
        return num;
    }
}

// v2: math
public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
