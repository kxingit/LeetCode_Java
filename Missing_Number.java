/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
*/
public class Solution {
    public int missingNumber(int[] nums) {
        // 11:45 - 11:46
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;
        int noMissingSum = (0 + n) * (n + 1) / 2;
        return noMissingSum - sum;
    }
}
