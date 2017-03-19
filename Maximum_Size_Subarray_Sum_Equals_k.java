/*
   Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
   */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // 8:10 - 8:16 - 8:35
        int n = nums.length;
        int[] presum = new int[n];
        int[] endsum = new int[n];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                presum[i] = nums[i];
            } else {
                presum[i] = nums[i] + presum[i - 1];
            }
            sum += nums[i];
            map.put(presum[i], i);
        }
        
        int res = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1) {
                endsum[i] = nums[i];
            } else {
                endsum[i] = endsum[i + 1] + nums[i];
            }
            int gap = sum + k - endsum[i];
            if(map.containsKey(gap)) {
                res = Math.max(res, map.get(gap) - i + 1);
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // 8:37 - 8:41 - 9:06
        HashMap<Integer, Integer> map = new HashMap();
        int n = nums.length;
        int[] sum = new int[n];
        int res = 0;
        
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                sum[0] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
            
            if(sum[i] == k) {
                res = Math.max(res, i + 1);
            }
            
            int gap = sum[i] - k;
            if(map.containsKey(gap)) {
                res = Math.max(res, i - map.get(gap));
            }
            if(!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            }
        }
        
        return res;
    }
}

// v3
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // 10:01 - 10:07
        HashMap<Integer, Integer> map = new HashMap();
        int n = nums.length;
        int[] sum = new int[n];
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                sum[0] = nums[0];
            } else {
                sum[i] = nums[i] + sum[i - 1];
            }
        
            if(sum[i] == k) {
                res = Math.max(res, i + 1);
            }
            if(map.containsKey(sum[i] - k)) {
                res = Math.max(res, i - map.get(sum[i] - k));
            }
            
            if(map.containsKey(sum[i]) == false) {
                map.put(sum[i], i);
            }
        }
        return res;
    }
}
