/*
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:
 *
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 */
public class Solution {
    public int countArrangement(int N) {
        // 10:57 - 10:59 // wrong, e.g. in 2, 3, 6, 2 and 3 are not interchangable 
        int res = 1;
        for(int i = 1; i <= N; i++) {
            int currdiv = 0;
            for(int j = i; j <= N; j++) {
                if(j % i == 0) {
                    currdiv++;
                }
            }
            res *= currdiv;
        }
        return res;
    }
}

// v2
public class Solution {
    public int res = 0;
    public int countArrangement(int N) {
        // 11:20 - 11:48
        List<Integer> solution = new ArrayList();
        boolean[] isVisited = new boolean[N + 1];
        dfs(N, solution, isVisited);
        return res;
    }
    private void dfs(int N, List solution, boolean[] isVisited) {
        if(solution.size() == N) {
            res++;
        }
        for(int i = 1; i <= N; i++) {
            if(isVisited[i]) continue;
            int pos = solution.size() + 1;
            if(i % pos == 0 || pos % i == 0) {
                solution.add(i);
                isVisited[i] = true;
                dfs(N, solution, isVisited);
                solution.remove(solution.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}
