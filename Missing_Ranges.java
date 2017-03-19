/*
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // 2:34 - 2:46 - 2:50
        int n = nums.length;
        List<String> res = new ArrayList();
        if(n == 0) {
            if(lower == upper) {
                res.add("" + lower);
            } else {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        long start = lower, end = 0;
        
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(lower < nums[0]) {
                    start = (long)lower;
                    end = (long)nums[0] - 1;
                } else {
                    continue;
                }
            } else {
                if((long)nums[i - 1] + 1 < (long)nums[i]) {
                    start = (long)nums[i - 1] + 1;
                    end = (long)nums[i] - 1;
                } else {
                    continue;
                }
            }
            if(start == end) {
                res.add(Long.toString(start));
            } else {
                res.add(start + "->" + end);
            }
        }
        if(nums[n - 1] != upper) {
            System.out.print("here");
            start = (long)nums[n - 1] + 1;
            end = (long)upper;
            if(start == end) {
                res.add(Long.toString(start));
            } else {
                res.add(start + "->" + end);
            }
        }
        return res;
    }
}
