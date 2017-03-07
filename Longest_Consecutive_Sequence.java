/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        // 12:15 - 12:19
        HashSet<Integer> set = new HashSet();
        for(Integer num : nums) set.add(num);
        
        int res = 0; 
        for(Integer num : nums) {
            int curr = num;
            int currmax = 1;
            while(set.contains(++curr)) {
                currmax++;
                set.remove(curr);
            }
            curr = num;
            while(set.contains(--curr)) {
                currmax++;
                set.remove(curr);
            }
            res = Math.max(res, currmax);
        }
        return res;
    }
}
