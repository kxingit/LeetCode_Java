/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 2:53 - 3:10
        List<Integer> res = new ArrayList();
        int n = nums.length;
        if(n == 0) return res;
        if(n == 1) {
            res.add(nums[0]);
            return res;
        }
        int cand1 = nums[0], cand2 = nums[0];
        int count1 = 0, count2 = 0;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(num == cand1) {
                count1++;
            } else if(num == cand2) {
                count2++;
            } else { // neither
                if(count1 == 0) {
                    cand1 = num;
                    count1++;
                } else if(count2 == 0) {
                    cand2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
         
        count1 = 0; count2 = 0;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(num == cand1) count1++;
            if(num == cand2) count2++;
        }
         
        if(count1 > n / 3) res.add(cand1);
        if(count2 > n / 3 && cand2 != cand1) res.add(cand2);
         
        return res;
         
    }
}

// v2: cleaned
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 2:53 - 3:10
        List<Integer> res = new ArrayList();
        int n = nums.length;
        int cand1 = 0, cand2 = 0;
        int count1 = 0, count2 = 0;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(num == cand1) {
                count1++;
            } else if(num == cand2) {
                count2++;
            } else { // neither
                if(count1 == 0) {
                    cand1 = num;
                    count1++;
                } else if(count2 == 0) {
                    cand2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        
        count1 = 0; count2 = 0;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(num == cand1) count1++;
            if(num == cand2) count2++;
        }
        
        if(count1 > n / 3) res.add(cand1);
        if(count2 > n / 3) res.add(cand2);
        
        return res;
    }
}
