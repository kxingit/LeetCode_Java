/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 1:42 - 1:52
        int n = nums.length;
        if(n == 0) return 0;
        int l = 0, r = 0, currsum = nums[0];
        int res = Integer.MAX_VALUE;
        while(l < n && r < n) {
            if(currsum >= target) {
                System.out.print(l +""+r);
                res = Math.min(res, r - l + 1);
                currsum -= nums[l];
                l++;
            } else {
                r++;
                if(r >= n) break;
                currsum += nums[r];
            } 
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// v2
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // 12:30 - 12:34
        int n = nums.length;
        if(n == 0) return 0;
        int l = 0, r = 0;
        int sum = nums[0];
        
        int res = Integer.MAX_VALUE;
        while(l < n && r < n) {
            if(sum >= s) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            } else {
                if(++r < n) sum += nums[r];
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
