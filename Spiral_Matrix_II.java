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

// v3
public class Solution {
    public int[][] generateMatrix(int n) {
        // 11:00 - 11:04
        int m = n;
        int[][] matrix = new int[n][n];
        int count = 1;
        
        int nLvl = (Math.min(m, n) + 1) / 2;
        
        for(int ilvl = 0; ilvl < nLvl; ilvl++) {
            int lastRow = m - ilvl - 1;
            int lastCol = n - ilvl - 1;
            if(lastRow == ilvl) { // one row left
                for(int j = ilvl; j <= lastCol; j++) {
                    matrix[lastRow][j] = count++;
                }
            } else if(lastCol == ilvl) {
                for(int i = ilvl; i <= lastRow; i++) {
                    matrix[i][lastCol] = count++;
                }
            } else {
                for(int j = ilvl; j < lastCol; j++) {
                    matrix[ilvl][j] = count++;
                }
                for(int i = ilvl; i < lastRow; i++) {
                    matrix[i][lastCol] = count++;
                }
                for(int j = lastCol; j > ilvl; j--) {
                    matrix[lastRow][j] = count++;
                }
                for(int i = lastRow; i > ilvl; i--) {
                    matrix[i][ilvl] = count++;
                }
            }
        }
        
        return matrix;
    }
}
