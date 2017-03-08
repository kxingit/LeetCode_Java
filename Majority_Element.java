/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array
 */
public class Solution {
    public int majorityElement(int[] nums) {
        // 3:35 - 3:42
        int n = nums.length;
        int count = 0;
        int res = nums[0];
        for(int i = 0; i < n; i++) {
            if(nums[i] == res) {
                count++;
            } else {
                if(count == 0) {
                    res = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
}
