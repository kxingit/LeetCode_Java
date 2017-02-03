/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            res[i] = nBits(i);
        }
        return res;
    }
    private int nBits(int n) {
        int res = 0;
        while(n != 0) {
            if((n & 1) == 1) res++;
            n = n >> 1;
        }
        return res;
    }
}

// v2
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num ; ++i) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
