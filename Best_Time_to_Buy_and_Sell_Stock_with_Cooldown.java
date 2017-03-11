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

// v3
public class Solution {
    public int maxProfit(int[] prices) {
        // 1:39 - 1:48
        int n = prices.length;
        if(n < 2) return 0;
        if(n == 2) return Math.max(0, prices[1] - prices[0]);
        
        int[] has = new int[n];
        int[] no = new int[n];
        has[0] = -prices[0];
        no[0] = 0;
        has[1] = Math.max(-prices[0], -prices[1]);
        no[1] = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < n; i++) {
            has[i] = Math.max(has[i - 1], no[i - 2] - prices[i]);
            no[i] = Math.max(no[i - 1], prices[i] + has[i - 1]);
        }
        
        return no[n - 1];
    }
}

// v4
public class Solution {
    public int maxProfit(int[] prices) {
        // 1:39 - 1:48 - 1:50 Rolling array
        int n = prices.length;
        if(n < 2) return 0;
        if(n == 2) return Math.max(0, prices[1] - prices[0]);
        
        int[] has = new int[2];
        int[] no = new int[3];
        has[0] = -prices[0];
        no[0] = 0;
        has[1] = Math.max(-prices[0], -prices[1]);
        no[1] = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < n; i++) {
            has[i % 2] = Math.max(has[(i - 1) % 2], no[(i - 2) % 3] - prices[i]);
            no[i % 3] = Math.max(no[(i - 1) % 3], prices[i] + has[(i - 1) % 2]);
        }
        
        return no[(n - 1) % 3];
    }
}
