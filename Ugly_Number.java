/*
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 *
 * Note that 1 is typically treated as an ugly number.
 */
public class Solution {
    public boolean isUgly(int num) {
        // 2:48 - 2:51
        if(num <= 0) return false;
        if(num == 1) return true;
        while(num > 0 && num % 2 == 0) {
                num = num / 2;
        }
        while(num > 0 && num % 3 == 0) {
                num = num / 3;
        }
        while(num > 0 && num % 5 == 0) {
                num = num / 5;
        }
        return num == 1;
    }
}
