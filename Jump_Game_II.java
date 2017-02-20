/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

// Time Limit Exceeded: 91 / 92 test cases passed.
public class Solution {
    public int jump(int[] nums) {
        // 1:05 - 1:13
        int n = nums.length;
        if(n == 0 || nums[0] == 0) return 0;
        int[] dp = new int[n]; // min step to get to position 'n'
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(i - j <= nums[j]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                } 
            }
        }
        return dp[n - 1];
    }
}

// v2
public class Solution {
    public int jump(int[] nums) {
        // 1:05 - 1:13
        int n = nums.length;
        if(n == 0 || nums[0] == 0 || n == 1) return 0;
        int[] dp = new int[n]; // min step to get to position 'n'
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(i - j <= nums[j]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
            if(i + nums[i] >= n - 1) return dp[i] + 1;
        }
        return dp[n - 1];
    }
}


// v3
public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return 0;
        int currmax = 0;
        int lastmax = 0;
        int i = 0;
        int step = 0;
        while(i <= currmax && i < n) {     
            if(i > lastmax) {
                step++;
                lastmax = currmax;
            }
            currmax = Math.max(currmax, i + nums[i]);
            i++;
        }
        if(currmax < n - 1) return 0;
        else return step;
    }
}

// v4
public class Solution {
    public int jump(int[] nums) {
        int currmax = 0, n = nums.length, steps = 0, lastmax = currmax;
        for(int i = 0; i < n && i <= currmax; i++) {
            if(i > lastmax) {
                steps++;
                lastmax = currmax;
                if(currmax >= n - 1) break;
            }             
            currmax = Math.max(currmax, i + nums[i]);           
        }
        if(currmax >= n - 1) return steps;
        return 0;
    }
}

// v5
public class Solution {
    public int jump(int[] nums) {
        // 3:15 - 3:18
        int n = nums.length, currmax = 0, i = 0, lastmax = 0, nsteps = 0;
        while(i < nums.length && i <= currmax) {
            if(i > lastmax) {
                nsteps++;
                lastmax = currmax;
            }
            currmax = Math.max(currmax, i + nums[i]);
            i++;
        }
        if(i < n - 1) return 0; 
        return nsteps;
    }
}
