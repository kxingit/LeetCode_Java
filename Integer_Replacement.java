/*
 * Given a positive integer n and you can do operations as follow:
 *
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 */
public class Solution {
    public int integerReplacement(int n) {
        // 5:09 - 5:10
        return helper((long)n); // overflow
    }
    private int helper(long n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n % 2 == 1) {
            return 1 + Math.min(helper(n + 1), helper(n - 1));
        } else {
            return 1 + helper(n / 2);
        }
    }
}
