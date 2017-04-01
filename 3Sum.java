/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *     [-1, -1, 2]
 *     ]
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1:24 - 1:33
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int l = i + 1, r = n - 1;
            while(l < r) {
                if(l > i + 1 && nums[l] == nums[l - 1]) {
                    l++; 
                    continue;
                }
                if(r < n - 1 && nums[r] == nums[r + 1]){
                    r--;
                    continue;
                }
                
                if(nums[l] + nums[r] == target) {
                    List<Integer> solution = new ArrayList();
                    solution.add(nums[i]);
                    solution.add(nums[l]);
                    solution.add(nums[r]);
                    res.add(new ArrayList(solution));
                    l++;
                } else if(nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        
        return res;
    }
}
