/*
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 */
public class Solution {
    // 5:18 - 5:23
    int[] A;
 
    public Solution(int[] nums) {
        this.A = nums.clone();
    }
    
    public int pick(int target) {
        int count = 0;
        Random r = new Random();
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == target) {
                count++;
                if(count > 0 && r.nextInt(count) == count - 1) {
                    res = i;
                }
            }
        }
        return res;
    }
}

// v2
public class Solution {
    // 5:23 - 5:27
    int[] A;
 
    public Solution(int[] nums) {
        this.A = nums.clone();
    }
    
    public int pick(int target) {
        int count = 0;
        Random r = new Random();
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == target) {
                count++;
                if(r.nextInt(count) == 0) { // chance is 1/count
                    res = i;
                }
            }
        }
        return res;
    }
}
