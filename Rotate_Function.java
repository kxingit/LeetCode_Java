/*
 * Given an array of integers A and let n to be its length.
 *
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 *
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 */
public class Solution {
    public int maxRotateFunction(int[] A) {
        // 4:43 - 4:49
        int sum = 0, f = 0, n = A.length;
        for(int i = 0; i < n; i++) {
            sum += A[i];
            f += i * A[i];
        }
        
        int res = f;
        for(int i = 1; i < n; i++) {
            f = f + sum - n * A[n - i];
            res = Math.max(res, f);
        }
        return res;
    }
}
