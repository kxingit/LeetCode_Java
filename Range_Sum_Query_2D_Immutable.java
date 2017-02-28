/*
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class NumMatrix {
    // 2:54 - 3:13
    private int[][] sum;
    private int m, n;
    private boolean isZero = false;
 
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            isZero = true;
            return;
        }
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    sum[i + 1][j + 1] = matrix[i][j];
                } else if (i == 0) {
                    sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j];
                } else if (j == 0) {
                    sum[i + 1][j + 1] = matrix[i][j] + sum[i][j + 1];
                } else {
                    sum[i + 1][j + 1] = matrix[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        if(isZero) return 0; 
        return sum[r2 + 1][c2 + 1] - sum[r1][c2 + 1] - sum[r2 + 1][c1] + sum[r1][c1];
    }
}


