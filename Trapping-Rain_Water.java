/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 */
public class Solution {
    public int trap(int[] height) {
        // 3:25 - 3:29 - 3:35
        int start = 0, end = height.length - 1;
        if(height.length <= 2) return 0;
        int res = 0;
        while(start + 1 < end) {
            if(height[start] < height[end]) {
                int next = start + 1;
                res += Math.max(0, height[start] - height[next]);
                height[next] = Math.max(height[start], height[next]);
                start++;
            } else {
                int next = end - 1;
                res += Math.max(0, height[end] - height[next]);
                height[next] = Math.max(height[end], height[next]);
                end--;
            }
        }
        return res;
    }
}
