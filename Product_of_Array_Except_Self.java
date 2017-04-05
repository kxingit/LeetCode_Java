/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 10:51 - 10:53 works if no '0' in input
        int n = nums.length;
        int[] res = new int[n];
        int prod = 1;
        for(int num : nums) prod *= num;
        
        for(int i = 0; i < n; i++) {
            res[i] = prod / nums[i];
        }
        
        return res;
    }
}

// v2
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 10:55 - 10:59
        int n = nums.length;
        int[] prodleft = new int[n];
        int[] prodright = new int[n];
         
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                prodleft[0] = nums[0];
            } else {
                prodleft[i] = prodleft[i - 1] * nums[i];
            }
        }
         
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1) {
                prodright[i] = nums[i];
            } else {
                prodright[i] = prodright[i + 1] * nums[i];
            }
        }
         
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                res[i] = prodright[1];
            } else if(i == n - 1) {
                res[i] = prodleft[i - 1];
            } else {
                res[i] = prodleft[i - 1] * prodright[i + 1];
            }
        }
         
        return res;
    }
}

// v3
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 10:59 - 11:07 O(1) space
        int n = nums.length;
        int[] prodright = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1) {
                prodright[i] = nums[i];
            } else {
                prodright[i] = prodright[i + 1] * nums[i];
            }
        }
        
        int prodleft = 1;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                prodright[i] = prodright[1];
            } else if(i == n - 1) {
                prodleft = prodleft * nums[i - 1];
                prodright[i] = prodleft;
            } else {
                prodleft = prodleft * nums[i - 1];
                prodright[i] = prodleft * prodright[i + 1];
            }
        }
        
        return prodright;
    }
}
