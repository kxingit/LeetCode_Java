/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

// Time Limit Exceeded: 197 / 198 test cases passed.
public class Solution {
    public int maxProfit(int[] prices) {
        // 2:33 －2:50
        int n = prices.length;
        if(n == 0 || n == 1) return 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            int left = maxProf(prices, 0, i - 1);
            int right = maxProf(prices, i, n - 1);
            res = Math.max(res, left + right);
        }
        return res;
    }
    
    private int maxProf(int[] prices, int i, int j) {
        if(i >= j) return 0;
        int currmin = Integer.MAX_VALUE;
        int res = 0;
        for(int k = i; k <= j; k++) {
            currmin = Math.min(currmin, prices[k]);
            int profit = prices[k] - currmin;
            res = Math.max(res, profit);
        }
        return res;
    }
}

// v2
public class Solution {
    public int maxProfit(int[] prices) {
        // 3:15 - 3:32
        int n = prices.length;
        if(n <= 1) return 0;
        int currmin = prices[0];
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 1; i < n; i++) {
            currmin = Math.min(currmin, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - currmin);
        }
        int currmax = prices[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            currmax = Math.max(currmax, prices[i]);
            right[i] = Math.max(right[i + 1], currmax - prices[i]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, left[i] + right[i]);
        }
        return res;
    }
}
