/*
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n <= 2) return 0;
        int[] dp = new int[n]; // NOAS ends with the 'n'th elmenet
        Arrays.fill(dp, 0);
        int res = 0;
        for(int i = 2; i < n; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}

// v2
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // 10: 56 - 10:59
        int n = A.length, res = 0;
        if(n < 3) return 0;
        int[] dp = new int[n];
        for(int i = 2; i < n; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
