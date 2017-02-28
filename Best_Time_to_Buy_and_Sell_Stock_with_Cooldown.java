/*
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 */
// TLE: 207 / 211 test cases passed.
public class Solution {
    private int n;
    private int max = 0;
    public int maxProfit(int[] prices) {
        // 4:04 - 4:30
        int res = 0;
        n = prices.length;
        getMax(prices, 0, res);
        return max;
    }
    private void getMax(int[] prices, int start, int res) {
        if(start == n) return;
        for(int i = start; i < n; i++) {
            int tmp = res;
            res += oneMax(prices, start, i);
            getMax(prices, i + 2, res);
            max = Math.max(max, res);
            res = tmp;
        }
    }
    private int oneMax(int[] prices, int start, int end) {
        int result = 0, currmin = Integer.MAX_VALUE;
        for(int i = start; i < end; i++) {
            currmin = Math.min(currmin, prices[i]);
            result = Math.max(result, prices[end] - currmin);
        }
        return result;
    }
}

// v2: https://discuss.leetcode.com/topic/30421/share-my-thinking-process
public class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
