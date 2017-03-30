/*
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */
public class Solution {
    public int getSum(int a, int b) {
        // 1:33 - 1:34
        if(b == 0) return a;
        int sum_without_carry = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum_without_carry, carry);
    }
}
