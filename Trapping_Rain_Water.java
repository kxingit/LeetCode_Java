/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
*/
public class Solution {
    public int trap(int[] height) {
        // 10:32 - 10:37
        int n = height.length;
        if(n == 0) return 0;
        int l = 0, r = n - 1;
        int currh = Math.min(height[l], height[r]);
        
        int res = 0;
        while(l <= r) {
            if(height[l] < height[r]) {
                res += Math.max(0, currh - height[l]);
                currh = Math.max(currh, height[l]);
                l++;
            } else {
                res += Math.max(0, currh - height[r]);
                currh = Math.max(currh, height[r]);
                r--;
            }
        }
        return res;
    }
}
