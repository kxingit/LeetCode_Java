/*
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] times = new int[primes.length];
        int[] uglys = new int[n];
        uglys[0] = 1;
 
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * uglys[times[j]]);
            }
            uglys[i] = min;
 
            for (int j = 0; j < times.length; j++) {
                if (uglys[times[j]] * primes[j] == min) {
                    times[j]++;
                }
            }
        }
        return uglys[n - 1];
    }
}

// v2
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 12:09 - 12:19
        int np = primes.length;
        int[] p = new int[np];
        int[] cand = new int[np];
        Arrays.fill(p, 0);
        List<Integer> ugly = new ArrayList();
        ugly.add(1);
        while(ugly.size() < n) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < np; i++) {
                cand[i] = ugly.get(p[i]) * primes[i];
                min = Math.min(min, cand[i]);
            }
            ugly.add(min);
            for(int i = 0; i < np; i++) {
                if(min == cand[i]) p[i]++;
            }
        }
        return ugly.get(ugly.size() - 1);
    }
}
