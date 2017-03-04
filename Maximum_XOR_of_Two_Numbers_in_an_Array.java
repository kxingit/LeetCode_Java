/*
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 */

// TLE: 28 / 29 test cases passed.
public class Solution {
    public int findMaximumXOR(int[] nums) {
        // 4:17 - 4:18
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; --i) {
            mask |= (1 << i);
            HashSet<Integer> s = new HashSet();
            for (int num : nums) {
                s.add(num & mask);
            }
            int t = res | (1 << i);
            for (Integer prefix : s) {
                if (s.contains(t ^ prefix)) {
                    res = t;
                    break;
                }
            }
        }
        return res;
    }
}
