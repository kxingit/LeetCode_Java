/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // 12:56 - 1:01
        int n = nums.length;
        if(n == 0) return true;
        int currmax = nums[0];
        int i = 0;
        while(i <= currmax) {
            currmax = Math.max(currmax, i + nums[i]);
            i++;
            if(currmax >= n - 1) return true;
        }
        return false;
    }
}
