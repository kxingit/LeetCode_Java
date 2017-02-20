/*
 * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.
 */
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 对于每头猪，它应有5种状态：15min、30min、45min、60min死亡和活着： ntest + 1 种状态
        if(buckets == 1) return 0;
        int states = minutesToTest / minutesToDie + 1;
        int i = 1;
        while(Math.pow(states, i) < buckets) {
            i++;
        }
        return i;
    }
}

// v2
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int res = 0;
        while(Math.pow(states, res) < buckets) { // state is base!!!
            res++;
        }
        return res;
    }
}

// v3
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 1:30 - 1:33
        int base = minutesToTest / minutesToDie + 1;
        return (int)Math.ceil(Math.log(buckets) / Math.log(base));
    }
}
