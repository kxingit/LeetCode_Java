/*
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
// TLE: 32 / 555 test cases passed.
public class Solution {
    public int findMaxLength(int[] nums) {
        // 9:58 - 10:07
        int n = nums.length, res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if((i - j + 1) % 2 == 1) continue;
                int n1s = getN1s(nums, j, i);
                if(n1s == (i - j + 1) / 2) {
                    res = Math.max(res, i - j + 1);
                }
            }
        }
        return res;
    }
    private int getN1s(int[] nums, int j, int i) {
        int res = 0;
        for(int k = j; k <= i; k++) {
            if(nums[k] == 1) res++;
        }
        return res;
    }
}

// v2: Memory Limit Exceeded
public class Solution {
    public int findMaxLength(int[] nums) {
        // 9:58 - 10:07 - 10:22
        int n = nums.length, res = 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if((i - j + 1) % 2 == 1) continue;
                int n1s = getN1s(nums, j, i, dp);;
                if(n1s == (i - j + 1) / 2) {
                    res = Math.max(res, i - j + 1);
                }
            }
        }
        return res;
    }
    private int getN1s(int[] nums, int j, int i, int[][] dp) {
        if(dp[j][i] >= 0) return dp[j][i];
        int res = 0;
        for(int k = j; k <= i; k++) {
            res += nums[k];
        }
        dp[j][i] = res;
        return res;
    }
}

// v3
public class Solution {
    public int findMaxLength(int[] nums) {
        // 10:50 - 10:52 - 10:58
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        HashMap<Integer, Integer> map = new HashMap(); // first position of sum
        int sum = 0, res = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
