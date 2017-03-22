/*
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 */
public class Solution {
    int count = 0;
    public int numberOfPatterns(int m, int n) {
        // 2:21 - 2:35 - 2:43 - 3:00
        //  No jumps through non selected key is allowed.
        boolean[] visited = new boolean[10];
        List<Integer> solution = new ArrayList();
        dfs(m, n, visited, solution);
        return count;
    }
    
    public void dfs(int m, int n, boolean[] visited, List<Integer> solution) {
        if(solution.size() > n) return;
        if(skip(visited, solution)) return;
        if(solution.size() >= m && solution.size() <= n) count++;
        for(int i = 1; i <= 9; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            solution.add(i);
            dfs(m, n, visited, solution);
            visited[i] = false;
            solution.remove(solution.size() - 1);
        }
    }
    
    public boolean skip(boolean[] visited, List<Integer> solution) {
        if(solution.size() < 2) return false;
        int first = solution.get(solution.size() - 1);
        int second = solution.get(solution.size() - 2);
        if(first == 1 && second == 3 && !visited[2]) return true;
        if(first == 4 && second == 6 && !visited[5]) return true;
        if(first == 7 && second == 9 && !visited[8]) return true;
        if(first == 1 && second == 7 && !visited[4]) return true;
        if(first == 2 && second == 8 && !visited[5]) return true;
        if(first == 3 && second == 9 && !visited[6]) return true;
        if(first == 1 && second == 9 && !visited[5]) return true;
        if(first == 3 && second == 7 && !visited[5]) return true;
        
        int tmp = first;
        first = second;
        second = tmp;
        if(first == 1 && second == 3 && !visited[2]) return true;
        if(first == 4 && second == 6 && !visited[5]) return true;
        if(first == 7 && second == 9 && !visited[8]) return true;
        if(first == 1 && second == 7 && !visited[4]) return true;
        if(first == 2 && second == 8 && !visited[5]) return true;
        if(first == 3 && second == 9 && !visited[6]) return true;
        if(first == 1 && second == 9 && !visited[5]) return true;
        if(first == 3 && second == 7 && !visited[5]) return true;
        
        return false;
    }
}
