/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int res = 0;
        while(tmp > 0) {
            if((tmp & 1) == 1) res++;
            tmp = tmp >> 1;
        }
        return res;
    }
}


// v2
public class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        while(temp > 0) {
            int lastBit = temp % 2;
            temp = temp >> 1;
            if(lastBit == 1) res++;
        }
        return res;
    }
}
