/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        // 2:33 - 2:38
        int[][] res = new int[n][n];
        int val = 1;
        for(int i = 0; i < n / 2; i++) {
            int last = n - i - 1;
            for(int j = i; j < last; j++) {
                res[i][j] = val++;
            }
            for(int j = i; j < last; j++) {
                res[j][last] = val++;
            }
            for(int j = last; j > i; j--) {
                res[last][j] = val++;
            }
            for(int j = last; j > i; j--) {
                res[j][i] = val++;
            }
        }
        if(n % 2 == 1) res[n / 2][n / 2] = val;
        return res;
    }
}

// v2
public class Solution {
    public int[][] generateMatrix(int n) {
        // 4:07 - 4:20
        int[][] res = new int[n][n];
        int val = 1;
        for(int ilevel = 0; ilevel < n / 2; ilevel++) {
            int first = ilevel, last = n - first - 1;
            for(int j = first; j < last; j++) {
                res[first][j] = val++;
            }
            for(int i = first; i < last; i++) {
                res[i][last] = val++;
            }
            for(int j = last; j > first; j--) {
                res[last][j] = val++;
            }
            for(int i = last; i > first; i--) {
                res[i][first] = val++;
            }
        }
        if(n % 2 == 1) res[n / 2][n / 2] = val;
        return res;
    }
}
