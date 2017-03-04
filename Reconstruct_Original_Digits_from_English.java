/*
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 */
public class Solution {
    public String originalDigits(String s) {
        StringBuffer res = new StringBuffer();
        int[] counts = new int[128];
        int[] nums = new int[10];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        nums[0] = counts['z'];
        nums[2] = counts['w'];
        nums[4] = counts['u'];
        nums[6] = counts['x'];
        nums[8] = counts['g'];
        nums[1] = counts['o'] - nums[0] - nums[2] - nums[4];
        nums[3] = counts['h'] - nums[8];
        nums[5] = counts['f'] - nums[4];
        nums[7] = counts['s'] - nums[6];
        nums[9] = counts['i'] - nums[6] - nums[8] - nums[5];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums[i]; ++j) {
                res.append(Integer.toString(i));
            }
        }
        return res.toString();
    }
}

