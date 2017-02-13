/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // 4:34 - 4:41
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        if(n == 0) return;
        
        boolean zero1row = false, zero1col = false;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) zero1col = true;
        }
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) zero1row = true;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0) matrix[i][j] = 0;
                if(matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        
        for(int i = 0; i < m; i++) {
            if(zero1col) matrix[i][0] = 0;
        }
        for(int j = 0; j < n; j++) {
            if(zero1row) matrix[0][j] = 0;
        }
    }
}
