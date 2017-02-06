/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 3:59 - 4:01
        int curr = 0, result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                result = Math.max(result, curr);
                curr = 0;
            } else {
                curr++;
            }
        }
        return Math.max(result, curr);
    }
}

// v2
public class Solution {
        int curr = 0, result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                curr = 0;
            } else {
                curr++;
                result = Math.max(result, curr);
            }
        }
        return result;
    }
}


// v3
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 1:33 - 1:35
        int res = 0, currmax = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                currmax++;
                res = Math.max(res, currmax);
            } else {
                currmax = 0;
            }
        }
        return res;
    }
}
