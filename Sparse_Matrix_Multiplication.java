/*
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 */
// v1: Brute force LTE
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        // 11:04
        int m = A.length, n = B[0].length, k = A[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int kk = 0; kk < k; kk++) {
                    res[i][j] += A[i][kk] * B[kk][j];
                }
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        // 11:04 - 11:11 swap the order, judge A[i][kk]
        int m = A.length, n = B[0].length, k = A[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int kk = 0; kk < k; kk++) {
                if(A[i][kk] == 0) continue;
                for(int j = 0; j < n; j++) {
                    res[i][j] += A[i][kk] * B[kk][j];
                }
            }
        }
        return res;
    }
}

// v3
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        // 12:05 - 12:08
        int m = A.length, k = A[0].length, n = B[0].length;
        int[][] res = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int kk = 0; kk < k; kk++) {
                if(A[i][kk] == 0) continue;
                for(int j = 0; j < n; j++) {
                    res[i][j] += A[i][kk] * B[kk][j];
                }
            }
        }
        
        return res;
    }
}
