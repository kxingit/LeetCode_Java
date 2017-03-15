/*
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        // 11:44 - 11:49
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                if(Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int findPairs(int[] nums, int k) {
        // 4:03 - 4:07
        HashMap<Integer, Integer> counts = new HashMap();
        for(Integer num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        int res = 0;
        if(k < 0) return 0;
        for(Integer num : counts.keySet()) {
            if(k == 0 && counts.get(num) > 1) {
                res++;
            } 
            if(k != 0) {
               if(counts.containsKey(num + k)) {
                   res++;
               } 
            }
        }
        return res;
    }
}
