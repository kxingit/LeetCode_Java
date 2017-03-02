/*
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 */
public class Solution {
    public int maxEnvelopes(int[][] A) {
        // 11:57 - 12:19
        if(A.length == 0) return 0;
        Arrays.sort(A, (a ,b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
        // LIS
        int m = A.length;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i][1] < A[j][1] && A[i][0] < A[j][0]) { // exlude equal
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int maxEnvelopes(int[][] A) {
        // 12:19 - 12:24    
        int n = A.length;
        if(n == 0) return 0;
        Arrays.sort(A, (a, b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i][0] < A[j][0] && A[i][1] < A[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
