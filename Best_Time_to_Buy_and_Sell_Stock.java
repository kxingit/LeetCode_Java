/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // 6:18 - 6:20
        int currmin = Integer.MAX_VALUE;
        int profit = 0; 
        for(int i = 0; i < prices.length; i++) {
            currmin = Math.min(currmin, prices[i]);
            profit = Math.max(profit, prices[i] - currmin);
        }
        return profit;
    }
}

// v2
public class Solution {
    public int maxProfit(int[] prices) {
        // 3:27 - 3:29
        if(prices.length == 0) return 0;
        int currmin = prices[0];
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            res = Math.max(res, prices[i] - currmin);
            currmin = Math.min(currmin, prices[i]);
        }
        return res;
    }
}

// v3
public class Solution {
    public int maxProfit(int[] prices) {
        // 9:05 - 9:07
        int n = prices.length;
        int currmin = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i = 0; i < n; i++) {
            currmin = Math.min(currmin, prices[i]);
            res = Math.max(res, prices[i] - currmin);
        }
        
        return res;
    }
}

// v4
public class Solution {
    public int maxProfit(int[] prices) {
        // 11:44 - 11:45
        int res = 0;
        int currmin = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            currmin = Math.min(prices[i], currmin);
            res = Math.max(res, prices[i] - currmin);
        }
        return res;
    }
}
