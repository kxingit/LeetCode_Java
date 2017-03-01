/*
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        // 2:10 - 2:14
        int i = 0, res = 0;
        long know_sum = 1;
        while(know_sum <= n) {
            if(i < nums.length && know_sum >= nums[i]) {
                know_sum += nums[i++];
            } else {
                know_sum *= 2;
                res++;
            }
        }
        return res;
    }
}
