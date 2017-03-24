/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
// Permutaion with duplacates
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 3:43 - 3:46 - 2:19
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, solution, result);
        return result;
    }
    private void dfs(int[] nums, boolean[] visited, List<Integer> solution, List<List<Integer>> result) {
        if(solution.size() == nums.length) result.add(new ArrayList(solution));
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) continue; // key!! 
            // for same numbers, we always require the earlier numbers have already been used!
            int num = nums[i];
            visited[i] = true;
            solution.add(num);
            dfs(nums, visited, solution, result);
            solution.remove(solution.size() - 1);
            visited[i] = false;
        }
    }
}
