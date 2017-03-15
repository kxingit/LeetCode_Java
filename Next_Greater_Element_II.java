/*
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = nextGreater(nums, i);
        }
        return res;
    }
    private int nextGreater(int[] nums, int pos) {
        for(int i = pos + 1; i < nums.length; i++) {
            if(nums[i] > nums[pos]) {
                return nums[i];
            }
        }
        for(int i = 0; i < pos; i++) {
            if(nums[i] > nums[pos]) {
                return nums[i];
            }
        }
        return -1;
    }
}

// v2
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = nextGreater(nums, i);
        }
        return res;
    }
    private int nextGreater(int[] nums, int pos) {
        int n = nums.length;
        for(int i = pos + 1; i < nums.length * 2; i++) { // trick: "double" the array
            if(nums[i % n] > nums[pos % n]) {
                return nums[i % n];
            }
        }
        return -1;
    }
}

// v3
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 11:10 - 11:14
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = -1;
            for(int j = i + 1; j < n * 2; j++) {
                if(nums[j % n] > nums[i]) {
                    res[i] = nums[j % n];
                    break;
                }
            }
        }
        return res;
    }
}
