/*
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 1:44 - 1:45
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
}
