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

// v4
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 7:54 - 7:58
        int n = nums.length;
        int[] leftprod = new int[n];
        int[] rightprod = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                leftprod[i] = nums[0];
            } else {
                leftprod[i] = nums[i] * leftprod[i - 1];
            }
        }
        
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1) {
                rightprod[i] = nums[i];
            } else {
                rightprod[i] = nums[i] * rightprod[i + 1];
            }
        }
        
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                res[i] = rightprod[i + 1];
            } else if(i == n - 1) {
                res[i] = leftprod[i - 1];
            } else {
                res[i] = leftprod[i - 1] * rightprod[i + 1];
            }
        }
        
        return res;
    }
}

// v5
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 7:58 - 8:08
        int n = nums.length;
        
        int[] res = new int[n];
        int leftprod = 1;
        
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1) {
                res[i] = nums[i];
            } else {
                res[i] = nums[i] * res[i + 1];
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(i == 1) {
                leftprod = nums[0];
            } else if (i > 1) {
                leftprod = nums[i - 1] * leftprod;
            }
            
            if(i == 0) {
                res[i] = res[i + 1];
            } else if(i == n - 1) {
                res[i] = leftprod;
            } else {
                res[i] = leftprod * res[i + 1];
            }
        }
        
        return res;
    }
}
