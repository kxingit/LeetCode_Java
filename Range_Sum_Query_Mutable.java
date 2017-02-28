/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 */
// TLE: 9 / 10 test cases passed.
public class NumArray {
    // 3:46 - 3:54
    int[] sum; int n;
    int[] A;
    public NumArray(int[] nums) {
        n = nums.length;
        A = nums;
        sum = new int[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
    }
    
    public void update(int i, int val) {
        int diff = val - A[i];
        for(int k = i; k < n; k++) {
            sum[k + 1] += diff;
        }
        A[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
} 
