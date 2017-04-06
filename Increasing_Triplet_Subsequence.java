/* 
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 3:35 - 4:00
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] >= 3) return true;
                }
            }
        }
        return false;
    }
}

// v2
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 4:24 - 4:32
        int m1 = Integer.MAX_VALUE, m2 = m1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= m1) {
                m1 = nums[i];
            } else if(nums[i] <= m2) {
                m2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}


// v3
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 10:36 - 10:40
        int m1 = Integer.MAX_VALUE, m2 = m1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= m1) {
                m1 = nums[i];
            } else if(nums[i] <= m2) {
                m2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}

// v4
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 3:10 3:12
        int min = Integer.MAX_VALUE, mid = min;
        for(int num : nums) {
            if(num <= min) {
                min = num;
            } else if(num < mid) {
                mid = num;
            } else if(num > mid) {
                return true;
            }
        }
        return false;
    }
}
