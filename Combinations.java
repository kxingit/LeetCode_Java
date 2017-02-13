/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 3:25 - 3:29
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList();
        gen(n, k, 1, solution, result);
        return result;
    }
     private void gen(int n, int k, int start, List<Integer> solution, List<List<Integer>> result) { // short??
        if(solution.size() == k) {
            result.add(new ArrayList(solution));
            return;
        }
        for(int i = start; i <= n; i++) {
            solution.add(i);
            gen(n, k, i + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
     }
}

// v2
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 9:52 - 9:56
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList();
        dfs(n, k, 1, solution, result);
        return result;
    }
    private void dfs(int n, int k, int start, List solution, List result) {
        if(solution.size() == k) {
            result.add(new ArrayList(solution));
            return;
        }
        for(int i = start; i <= n; i++) {
            solution.add(i);
            dfs(n, k, i + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
    }
}
