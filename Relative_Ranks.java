/*
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        // 1:22 - 1:53
        int n = nums.length;
        int[] originalNums = nums.clone();
        Arrays.sort(nums);
        HashMap<Integer, Integer> rankMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int rank = n - i;
            rankMap.put(nums[i], rank);
        }
        String[] res = new String[n];
        for(int i = 0; i < n; i++) {
            int num = originalNums[i];
            int rank = rankMap.get(num);
            String s = new String();
            s = Integer.toString(rank);
            if(rank == 1) s = "Gold Medal";
            if(rank == 2) s = "Silver Medal";
            if(rank == 3) s = "Bronze Medal";
            res[i] = s;
        }
        return res;
    }
}

// lambda expression?
