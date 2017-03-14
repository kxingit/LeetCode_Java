/*
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 12:22 - 12:24 - 12:45
        int n = nums.length;
        int[] sum = new int[n];
        
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        if(k == 0) k = Integer.MAX_VALUE;
        
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < n; i++) {
            if(i == 0) sum[i] = nums[i];
            else sum[i] = sum[i - 1] + nums[i];
            if(!map.containsKey(sum[i] % k)) map.put(sum[i] % k, i);
            if((i >= 1 && sum[i] % k == 0) || i - map.get(sum[i] % k) > 1) return true;
        }
        return false;
    }
}
