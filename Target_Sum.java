/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // 2:00 - 3:00
        int m = 2001;
        int shift = m / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1]; // sum + 1000
        // for(int i = 0; i < n + 1; i++) dp[i][0 + shift] = 1;
        dp[0][shift] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j - nums[i] >= 0) {
                   dp[i + 1][j] += dp[i][j - nums[i]];
                }
                if(j + nums[i] <= m) {
                    dp[i + 1][j] += dp[i][j + nums[i]];
                }
            }
        }
        if(S > shift) return 0;
        return dp[n][S + shift];
    }
}

// v2
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // 2:02 - 2:21
        int n = nums.length, m = 2000;
        int[][] dp = new int[n + 1][2001];
        dp[0][1000] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j >= nums[i]) {
                    dp[i + 1][j] += dp[i][j - nums[i]];
                }
                if(j + nums[i] <= m) {
                    dp[i + 1][j] += dp[i][j + nums[i]];
                }
            }
        }
        if(S > 1000) return 0;
        return dp[n][S + 1000];
    }
}

// v3
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // 10:54 - 11:03
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        
        for(int num : nums) {
            HashMap<Integer, Integer> newmap = new HashMap();
            for(int sum : map.keySet()) {
                newmap.put(sum + num, newmap.getOrDefault(sum + num, 0) + map.get(sum));
                newmap.put(sum - num, newmap.getOrDefault(sum - num, 0) + map.get(sum));
            }
            map = newmap;
        }
        
        return map.getOrDefault(S, 0);
    }
}


// v7
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // 11:32 - 11:40
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        for(int num : nums) {
            Map<Integer, Integer> newmap = new HashMap();
            for(Integer sum : map.keySet()) {
                newmap.put(sum + num, newmap.getOrDefault(sum + num, 0) + map.get(sum)); // new[sum + num] = new[sum + num] + old[sum]
                newmap.put(sum - num, newmap.getOrDefault(sum - num, 0) + map.get(sum));
            }
            map = newmap;
        }
        return map.getOrDefault(S, 0);
    }
}
