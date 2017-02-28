/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */
public class NumArray {
    // 2:47 - 2:50
    private int[] sum;
    private int n;
 
    public NumArray(int[] nums) {
        n = nums.length;
        sum = new int[n];
        if(n != 0) sum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return sum[j];
        return sum[j] - sum[i - 1];
    }
}
