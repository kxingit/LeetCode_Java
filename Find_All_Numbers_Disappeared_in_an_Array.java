/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 1:21 - 1:28
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}


// v2
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 2:14 - 2:19
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) nums[idx] *= -1;
        }
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }
}

// v3 swap
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 2:25 - 2:46
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// v4
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 2:47 - 2:51
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) result.add(i + 1);
        }
        return result;
    }
}
