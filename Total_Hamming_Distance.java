/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 */

// Time Limit Exceeded: 36 / 47 test cases passed.
public class Solution {
    public int totalHammingDistance(int[] nums) {
        // 1:41 - 1:44
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                res += getHamming(nums[i], nums[j]);
            }
        }
        return res;
    }
    private int getHamming(int i, int j) {
        int temp = i ^ j;
        int res = 0;
        while(temp > 0) {
            int lastBit = temp & 1;
            temp = temp >> 1;
            if(lastBit == 1) res++;
        }
        return res;
    }
}

// v2
public class Solution {
    public int totalHammingDistance(int[] nums) {
        // 1:54 - 1:56
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int n1bit = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & 1) == 1) n1bit++;
                nums[j] = nums[j] >> 1;
            }
            res += n1bit * (nums.length -n1bit);
        }
        return res;
    }
}
