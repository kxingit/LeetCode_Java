/*
   You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

   Given n, find the total number of full staircase rows that can be formed.

   n is a non-negative integer and fits within the range of a 32-bit signed integer.
   */
public class Solution {
    public int arrangeCoins(int n) {
        // 9:18 - 9:20
        int i = 0;
        while(i * (1 + i) / 2 <= n) {
            i++;
        }
        return i - 1;
    }
}

// v2
public class Solution {
    public int arrangeCoins(int n) {
        // 9:25 - 9:26
        return (int) (-0.5 + Math.sqrt(0.25 + 2 * (double)n));
    }
}
