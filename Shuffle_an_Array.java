/*
 * Shuffle a set of numbers without duplicates.
 */
public class Solution {
    // 11:47 - 11:53
    int[] original, res;
 
    public Solution(int[] nums) {
        original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random r = new Random();
        res = original.clone();
        for(int i = 0; i < res.length; i++) {
            int randidx = r.nextInt(i + 1);
            int tmp = res[i];
            res[i] = res[randidx];
            res[randidx] = tmp;
        }
        return res;
    }
}
