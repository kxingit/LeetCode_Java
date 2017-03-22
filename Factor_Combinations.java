/*
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 *   Write a function that takes an integer n and return all possible combinations of its factors.
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        // 10:28 - 10:33 - 10:46 
        List<List<Integer>> res = new ArrayList();
        List<Integer> solution = new ArrayList();
        List<Integer> factors = new ArrayList();
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                factors.add(i);
            }
        }
        dfs(n, factors, 0, solution, res);
        return res;
    }
    
    public void dfs(int curr, List<Integer> factors, int start, List<Integer> solution, List<List<Integer>> res) {
        if(curr == 1) {
            if(solution.size() > 1) {
                res.add(new ArrayList(solution));
            }
        }
        for(int i = start; i < factors.size(); i++) { // <=
            if(i > start && factors.get(i) == factors.get(i - 1)) continue; // not necessary
            if(curr % factors.get(i) != 0) continue;
            solution.add(factors.get(i));
            dfs(curr / factors.get(i), factors, i, solution, res); // not i + 1
            solution.remove(solution.size() - 1);
        }
    }
}
