/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 6:54 - 6:56
        int n = heights.length;
        int[] A = new int[n + 1];
        for(int i = 0; i < n; i++) A[i] = heights[i];
        A[n] = 0;
        int res = 0;
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < A.length; i++) {
            while(!stack.isEmpty() && A[i] < A[stack.peek()]) {
                int h = A[stack.peek()];
                stack.pop();
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
    public int largestRectangleArea(int[] heights) {
        // 8:36 - 8:46
        int n = heights.length + 1;
        int[] A = new int[n];
        for(int i = 0; i < n - 1; i++) A[i] = heights[i];
        Stack<Integer> stack = new Stack();
        int res = 0;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && A[i] < A[stack.peek()]) {
                int h = A[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}

// brute force: TLE: 94 / 96 test cases passed.
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 8:47 - 8:50
        int n = heights.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            int minh = heights[i];
            for(int j = i; j < n; j++) {
                minh = Math.min(minh, heights[j]);
                int w = j - i + 1;
                res = Math.max(res, minh * w);
            }
        }
        return res;
    }
}

// v3
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 8:54 - 9:16
        int n = heights.length;
        int max = 0;
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i <= n; i++) {
            int currh = (i == n ? -1 : heights[i]);
            while(!stack.isEmpty() && currh < heights[stack.peek()]) { // compare to the height, not index!
                int h = heights[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
