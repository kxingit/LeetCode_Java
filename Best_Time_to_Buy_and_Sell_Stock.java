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
