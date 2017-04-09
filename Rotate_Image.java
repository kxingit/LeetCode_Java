/*
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 */
public class Solution {
	int n;
    public void rotate(int[][] matrix) {
		n = matrix.length;
		flipdiag(matrix);
		flip(matrix);
    }

	public void flipdiag(int[][] matrix) {
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}

	public void flip(int[][] matrix) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				maxtrix[i][j] = maxtrix[i][n - j];
				maxtrix[i][n - j] = tmp;
			}
		}
	}
}

// v2
public class Solution {
    int n;
    public void rotate(int[][] matrix) {
        // 10:56 - 11:08
        n = matrix.length;
        flipdiag(matrix);
        flip(matrix);
    }
    public void flipdiag(int[][] matrix) {
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    public void flip(int[][] matrix) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1]; // !!!
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}


// v3
public class Solution {
    int m, n;
    public void rotate(int[][] matrix) {
        // 2:37 - 2:41
        m = matrix.length;
        if(m == 0) return;
        n = matrix[0].length;
        
        flipDiag(matrix);
        flip(matrix);
    }
    
    public void flipDiag(int[][] matrix) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    public void flip(int[][] matrix) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
