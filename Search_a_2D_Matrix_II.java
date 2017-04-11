/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 */
public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
	// 12:55 - 12:58
	int m = matrix.length;
	if(m == 0) return false;
	int n = matrix[0].length;
	if(n == 0) return false;
	int i = m - 1, j = 0;
	while(i >= 0 && j < n) {
	  if(matrix[i][j] == target) {
		return true;
	  } else if (matrix[i][j] > target) {
		i--;
	  } else {
		j++;
	  }
	}
	return false;
  }
}

// v2
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 10:25 - 10:27
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        
        int i = m - 1, j = 0;
        while(i >= 0 && j < n) {
            if(target == matrix[i][j]) {
                return true;
            } else if(target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        
        return false;
    }
}
