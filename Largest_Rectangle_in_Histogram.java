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

// brutal force?
