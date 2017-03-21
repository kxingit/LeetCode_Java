/*
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2. Because there are two triplets which sums are less than 2:
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        // 11:46 - 11:49
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        
        for(int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] >= target) {
                    k--;
                } else {
                    res += k - j;
                    j++;
                }
            }
        }
        
        return res;
    }
}
