/* 
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
*/
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 8:40 - 8:48 wrong [0,0,0,0,0,0,0,0,0,0] 0
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int res = 0;
        for(int num : nums) {
            HashMap<Integer, Integer> newmap = new HashMap();
            for(Integer sum : map.keySet()) {
                int newsum = sum + num;
                if(newsum == k) res++;
                newmap.put(newsum, 1 + newmap.getOrDefault(newsum, 0));
            }
            map = newmap;
            if(num == k) res++;
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        
        return res;
    }
}
