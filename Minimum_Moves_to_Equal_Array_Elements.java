/*
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 */
public class Solution {
    public int minMoves(int[] nums) {
        // 10:42 - 10:43
        int min = Integer.MAX_VALUE, n = nums.length;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += nums[i] - min;
        }
        return res;
    } 
}
