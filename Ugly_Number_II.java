/*
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        List<Integer> list = new ArrayList();
        list.add(1);
        int i = 0, j = 0, k = 0;
        while(list.size() < n) {
            int m2 = list.get(i) * 2, m3 = list.get(j) * 3, m5 = list.get(k) * 5;
            int min = Math.min(Math.min(m2, m3), m5);
            list.add(min);
            if(min == m2) i++;
            if(min == m3) j++;
            if(min == m5) k++;
        }
        return list.get(list.size() - 1);
    }
}


// v2
public class Solution {
    public int nthUglyNumber(int n) {
        int[] primes = {2, 3, 5};
        return nthSuperUglyNumber(n, primes);
        
    }
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
