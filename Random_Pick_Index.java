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

// v3
public class Solution {
    // 3:20 - 3:25
    HashMap<Integer, List<Integer>> map = new HashMap();
    Random r = new Random();
 
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.get(num) == null) {
                map.put(num, new ArrayList());
            }
            map.get(num).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(r.nextInt(list.size()));
    }
}

// v4
public class Solution {
    // 3:29 - 3:33
    int[] nums;
    Random r;
 
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    public int pick(int target) {
        int res = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
                if(r.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}


// v5
public class Solution {
    // 9:43 - 9:47
    int[] nums;
    Random r;
 
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    public int pick(int target) {
        int res = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == target) {
                count++;
                if(r.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}


