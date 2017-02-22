/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        // 10:39 - 10:56
        List<String> solution = new ArrayList();
        List<List<String>> result = new ArrayList();
        dfs(s, 0, solution, result);
        return result;
    }
    private void dfs(String s, int start, List<String> solution, List result) {
        int n = s.length();
        if(start == n) {
            result.add(new ArrayList(solution));
        }
        for(int i = start; i < n; i++) {
            String sub = s.substring(start, i + 1);
            if(!isPal(sub)) continue;
            solution.add(sub);
            dfs(s, i + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
    }
    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}

// v2
public class Solution {
    public List<List<String>> partition(String s) {
        // 11:10 - 11:17
        List<List<String>> result = new ArrayList();
        List<String> solution = new ArrayList();
        dfs(s, 0, solution, result);
        return result;
    }
    private void dfs(String s, int start, List solution, List result) {
        if(start == s.length()) {
            result.add(new ArrayList(solution)); // !!!
            return;
        }
        for(int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if(!isPal(sub)) continue;
            solution.add(sub);
            dfs(s, i + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
    }
    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
