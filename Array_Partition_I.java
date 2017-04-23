/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b2), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
*/
public class Solution {
    public int arrayPairSum(int[] nums) {
        // 9:01 - 9:02
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < n / 2; i++) {
            res += nums[2 * i];
        }
        return res;
    }
}
