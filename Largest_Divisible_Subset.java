/*
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 */
// TLE: 35 / 36 test cases passed.
public class Solution {
    private List<Integer> result = new ArrayList();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 2:13 - 2:18
        Arrays.sort(nums);
        List<Integer> solution = new ArrayList();
        dfs(nums, 0, solution);
        return result;
    }
    private void dfs(int[] nums, int start, List<Integer> solution) {
        if(solution.size() > result.size()) {
            result = new ArrayList(solution);
        }
        for(int i = start; i < nums.length; i++) {
            if(solution.size() != 0 && nums[i] % solution.get(solution.size() - 1) != 0) {
                continue;
            }
            solution.add(nums[i]);
            dfs(nums, i + 1, solution);
            solution.remove(solution.size() - 1);
        }
    }
}

// v2: DP
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 2:41 DP - 2:49
        int n = nums.length;
        List<Integer> res = new ArrayList();
        if(n == 0) return res;
        int[][] dp = new int[n][2]; // [0]: max length; [1]: last number
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }
        Arrays.sort(nums);
        int maxlen = 1;
        int last = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0 && dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                    if(maxlen < dp[i][0]) {
                        maxlen = dp[i][0];
                        last = i;
                    }
                }
            }
        }
        for(int i = last; i != -1; i = dp[i][1]) {
            res.add(nums[i]);
        }
        return res;
    }
}

// v3
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 2:41 DP - 2:49 - 3:27
        int n = nums.length;
        List<Integer> res = new ArrayList();
        if(n == 0) return res;
        int[][] dp = new int[n][2]; // [0]: max length; [1]: last number
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }
        Arrays.sort(nums);
        int maxlen = 1;
        int last = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0 && dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
                if(maxlen < dp[i][0]) {
                    maxlen = dp[i][0];
                    last = i;
                }
            }
        }
        for(int i = last; i != -1; i = dp[i][1]) {
            res.add(nums[i]);
        }
        return res;
    }
}

// v4
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 4:05
        int n = nums.length;
        List<Integer> res = new ArrayList();
        if(n == 0) return res;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] dp_idx = new int[n];
        Arrays.fill(dp_idx, -1);
        int maxlen = 0, index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] < dp[j] + 1) {
                        dp_idx[i] = j;
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if(maxlen < dp[i]) {
                maxlen = dp[i];
                index = i; // 
                // System.out.print(i);
            }
        }
        while(index != -1) {
            res.add(0, nums[index]);
            index = dp_idx[index];
        }
        return res;
    }
}

// v5
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 4:38 - 4:43
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> res = new ArrayList();
        if(n == 0) return res;
        
        int[] dp = new int[n];
        int[] dp_idx = new int[n];
        Arrays.fill(dp_idx, -1);
        
        int maxlen = 0, index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[j] + 1 > dp[i]) dp_idx[i] = j;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(maxlen < dp[i]) {
                maxlen = dp[i];
                index = i;
            }
        }
        while(index != -1) {
            res.add(nums[index]);
            index = dp_idx[index];
        }
        return res;
    }
}
