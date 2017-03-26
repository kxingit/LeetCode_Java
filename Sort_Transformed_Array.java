/*
Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)
*/
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // 11:31
        int n = nums.length;
        int[] result = new int[n];
        
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        
        if(a == 0) {
            if(b > 0) {
                for(int i = 0; i < n; i++) {
                    int x = nums[i];
                    result[i] = b * x + c;
                }
            } else {
                for(int i = nums.length - 1; i >= 0; i--) {
                    int x = nums[i];
                    result[nums.length - 1 - i] = b * x + c;
                }
            }
            return result;
        }
        
        double mid;
        if(a != 0) {
            mid = (double)(-b) / 2 / a;
        } else {
            mid = Integer.MIN_VALUE;
        }
        for(Integer num : nums) {
            if(num < mid) {
                if(a >= 0) list1.add(num);
                else list2.add(num);
            } else {
                if(a >= 0) list2.add(num);
                else list1.add(num);
            }
        }
        
        List<Integer> res = new ArrayList();
        int i1 = list1.size() - 1, i2 = 0;
        while(i1 >= 0 && i2 < list2.size()) {
            if(mid - list1.get(i1) < list2.get(i2) - mid) {
                res.add(list1.get(i1));
                i1--;
            } else {
                res.add(list2.get(i2));
                i2++;
            }
        }
        while(i1 >= 0) {
            res.add(list1.get(i1));
            i1--;
        }
        while(i2 < list2.size()) {
            res.add(list2.get(i2));
            i2++;
        }
        
        for(int i = 0; i < res.size(); i++) {
            int x = res.get(i);
            result[i] = a * x * x + b * x + c;
        }
        return result;
    }
}
