/*
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * For example:
 *
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        // 2:39 - 2:44
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(Integer num : map.keySet()) {
            if(map.get(num) == 1) {
                res.add(num);
            }
        }
        int[] result = {res.get(0), res.get(1)};
        return result;
    }
}


// v2
public class Solution {
    public int[] singleNumber(int[] nums) {
        // 11:46 - 11:50
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int key = 1;
        while((key & xor) == 0) {
            key = key << 1;
        }
        int[] res = new int[2];
        res[0] = 0; res[1] = 0;
        for(int i = 0; i < nums.length; i++) {
            if((key & nums[i]) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
