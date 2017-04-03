/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 */
public class Solution {
    public void sortColors(int[] nums) {
        // 1:28 - 1:34
        int n = nums.length;
        int i = 0, l = 0, r = n - 1;
        while(i <= r) {
            if(nums[i] == 0) {
                swap(nums, i, l);
                i++; l++;
            } else if(nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// v2
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while(i <= r) {
            if(nums[i] == 0) {
                swap(nums, i, l);
                i++;
                l++;
            } else if(nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

// v3
public class Solution {
    public void sortColors(int[] nums) {
        // 5:02 - 5:04 - 5:08
        int n = nums.length;
        int l = 0, r = n - 1;
        for(int i = 0; i <= r; i++) { // '<='' !! 'r' could be 0 
            if(nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l++] = tmp;
            } else if(nums[i] == 1) {
                continue;
            } else {
                int tmp = nums[i];
                nums[i] = nums[r];
                nums[r--] = tmp;
                i--;
            }
        }
    }
}

// v4
public class Solution {
    public void sortColors(int[] nums) {
        // 5:09 - 5:11
        int[] count = new int[3];
        for(int num : nums) {
            count[num]++;
        }
        int ii = 0;
        for(int j = 0; j < 3; j++) {
            for(int i = 0; i < count[j]; i++) {
                nums[ii++] = j;
            }
        }
    }
}
