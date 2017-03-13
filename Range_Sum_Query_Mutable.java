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

// v2
public class NumArray {
    private int[] nums;
    private int[] bit;

    // Time Complexity: O(n)
    public NumArray(int[] nums) {
        // index 0 is unused
        this.nums = new int[nums.length + 1];
        this.bit = new int[nums.length + 1];

        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }

    // Time Complexity: O(log n)
    public void update(int index, int val) {
        final int diff = val - nums[index + 1];
        for (int i = index + 1; i < nums.length; i += lowbit(i)) {
            bit[i] += diff;
        }
        nums[index + 1] = val;
    }

    // Time Complexity: O(log n)
    public int sumRange(int i, int j) {
        return read(j + 1) - read(i);
    }

    private int read(int index) {
        int result = 0;
        for (int i = index; i > 0; i -= lowbit(i)) {
            result += bit[i];
        }
        return result;
    }

    private static int lowbit(int x) {
        return x & (-x);  // must use parentheses
    }
}

// v3: binary indexed tree
public class NumArray {
    private int[] nums;
    private int[] bit;

    public NumArray(int[] nums) {
        // Starts from index 1
        this.nums = new int[nums.length + 1];
        this.bit = new int[nums.length + 1];

        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        final int diff = val - nums[index + 1];
        for (int i = index + 1; i < nums.length; i += lowbit(i)) {
            bit[i] += diff;
        }
        nums[index + 1] = val;
    }

    public int sumRange(int i, int j) {
        return read(j + 1) - read(i);
    }

    private int read(int index) {
        int result = 0;
        for (int i = index; i > 0; i -= lowbit(i)) {
            result += bit[i];
        }
        return result;
    }

    private static int lowbit(int x) {
        return x & -x; 
    }
}
