/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 1:21 - 1:28
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}
