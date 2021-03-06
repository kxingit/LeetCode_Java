/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 12:09 - 12:13
        List<Integer> result = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                result.add(nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}

// v2
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) {
                result.add(Math.abs(nums[i]));
            }
             nums[idx] *= -1;
        }
        return result;
    }
}

// v3
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) result.add(nums[i]);
        }
        return result;
    }
}


// v4
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 10:59
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}

// v5
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 9:33 - 9:42
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
            else {
                result.add(idx + 1);
            }
        }
        return result;
    }
}


// v6
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 9:45 - 9:49
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
