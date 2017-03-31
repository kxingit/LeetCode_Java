/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        // 5:06 - 5:16 wrong, changed order
        int n = nums.length;
        int i = 0, j = n - 1;
        while(i < j) {
            if(nums[j] == 0) {
                j--;
            } else if(nums[i] != 0) {
                i++;
            } else {
                nums[i] = nums[j];
                nums[j] = 0;
                i++; j--;
            }
        }
    }
}

// v2
public class Solution {
    public void moveZeroes(int[] nums) {
        // 5:21 - 5:27
        int n = nums.length;
        int i = 0, j = 0;
        while(i < n && j < n) {
            if(nums[j] == 0) {
                j++;
            } else if(nums[i] != 0) {
                i++;
                j = i;
            } else {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }
        }
    }
}

// v3
public class Solution {
    public void moveZeroes(int[] nums) {
        // 5:35 - 5:37
        int n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}

// v4
public class Solution {
    public void moveZeroes(int[] nums) {
        // 9:16 - 9:18
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
