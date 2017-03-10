/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 4:47 - 5:06 
        List<List<Integer>> res = new ArrayList();
        List<Integer> solution = new ArrayList();
        dfs(n, k, 1, 0, solution, res);
        return res;
    }
    private void dfs(int n, int k, int start, int currsum, List solution, List res) {
        if(currsum > n) return;
        if(currsum == n && k == 0) {
            res.add(new ArrayList(solution));
            return;
        }
        for(int i = start; i <= 9; i++) {
            solution.add(i);
            dfs(n, k - 1, i + 1, currsum + i, solution, res); // forgot to restore currsum
            solution.remove(solution.size() - 1);
        }
    }
}
