/*
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 */

// Time Limit Exceeded: 14 / 27 test cases passed.
public class Solution {
    public int splitArray(int[] nums, int m) {
        // 2:37 - 2:45
        int n = nums.length;
        return largestSum(nums, 0, n - 1, m);
    }
    private int largestSum(int[] nums, int start, int end, int m) {
        if(end - start  + 1 < m) return Integer.MAX_VALUE;
        if(m == 1) {
            int sum = 0;
            for(int i = start; i <= end; i++) {
                sum += nums[i];
            }
            return sum;
        }
        int res = Integer.MAX_VALUE;
        int currmax = Integer.MIN_VALUE;
        for(int i = start; i < end; i++) {
            int sum = 0;
            for(int j = start; j <= i; j++) {
                sum += nums[j];
            }
            currmax = Math.max(sum, largestSum(nums, i + 1, end, m - 1));
            res = Math.min(res, currmax);
        }
        return res;
    }
}

// v2: binary search
public class Solution {
    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for (int i = 0; i < nums.length; ++i) {
            l = Math.max((int)l, nums[i]);
            r += nums[i];
        }
        long ans = 0;
        while(l <= r) {
            long mid = (l + r) / 2;
            if (canSplit(mid, nums, m)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }
    public boolean canSplit(long max_val, int[] nums, int m) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > max_val) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
}
