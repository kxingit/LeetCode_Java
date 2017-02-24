/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 10:47 - 11:17
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] heights = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    if(matrix[i][j] == '0') {
                        heights[i][j] = 0;
                    } else {
                        heights[i][j] = 1 + heights[i - 1][j];
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++) {
            res = Math.max(res, maxRec(heights[i]));
        }
        return res;
    }
    private int maxRec(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack();
        int res = 0;
        for(int i = 0; i <= A.length; i++) {
            int currh = i == A.length ? 0 : A[i];
            while(!stack.isEmpty() && currh < A[stack.peek()]) {
                int h = A[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}
