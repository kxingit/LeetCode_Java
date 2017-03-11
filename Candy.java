/*
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Solution {
    public int candy(int[] ratings) {
        // 3:16 - 3:27
        int n = ratings.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1); // !
            }
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += res[i];
        }
        return result;
    }
}

// v2
public class Solution {
    public int candy(int[] ratings) {
        // 9:35 - 9:40
        int n = ratings.length;
        if(n <= 1) return n;
        int result = 0;
        
        int[] res = new int[n];
        res[0] = 1;
        
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }
        
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
            result += res[i];
        }
        
        return result + res[n - 1];
    }
}

// v3
public class Solution {
    public int candy(int[] ratings) {
        // 10:18 - 10:22
        int n = ratings.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i + 1] + 1, dp[i]);
            }
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += dp[i];
        }
        
        return res;
    }
}
