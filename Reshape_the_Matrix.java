/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
*/
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // 8:33 - 8:35
        int m = nums.length;
        if(m == 0) return nums;
        int n = nums[0].length;
        if(m * n != r * c) return nums;
        
        int[][] res = new int[r][c];
        int k = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[k / c][k % c] = nums[i][j];
                k++;
            }
        }
        return res;
    }
}
