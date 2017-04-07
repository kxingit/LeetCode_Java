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

// v2
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 10:31 - 10:48
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        
        int[][] A = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') continue;
                if(i == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = A[i - 1][j] + 1;
                }
            }
        }
        
        int res = 0;
        for(int[] row : A) {
            int maxrec = getMaxRec(row);
            res = Math.max(res, maxrec);
        }
        
        return res;
    }
    
    public int getMaxRec(int[] nums) {
        int n = nums.length;
        int[] A = new int[n + 2];
        for(int i = 0; i < n; i++) {
            A[i + 1] = nums[i];
        }
        
        Stack<Integer> stack = new Stack();
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            while(stack.size() > 0 && A[stack.peek()] >= A[i]) {
                int h = A[stack.pop()];
                int start = stack.size() > 0 ? stack.peek() : -1;
                int w = i - start - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        
        return res;
    }
}

// v3
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 10:31 - 10:48
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        
        int[][] A = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') continue;
                if(i == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = A[i - 1][j] + 1;
                }
            }
        }
        
        int res = 0;
        for(int[] row : A) {
            int maxrec = getMaxRec(row);
            res = Math.max(res, maxrec);
        }
        
        return res;
    }
    
    public int getMaxRec(int[] nums) {
        int n = nums.length;
        
        Stack<Integer> stack = new Stack();
        int res = 0;

        for(int i = 0; i <= n; i++) {
            int currh = i == n ? 0 : nums[i];
            while(stack.size() > 0 && nums[stack.peek()] >= currh) { // nums[stack.peek()] is height, not stack.peek()
                int h = nums[stack.pop()];
                int w = stack.size() == 0 ? i : i - stack.peek() - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        
        return res;
    }
}
