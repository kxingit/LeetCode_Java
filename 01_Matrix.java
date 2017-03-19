/*
   Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

   The distance between two adjacent cells is 1.
   */
// Contest
// TLE: 32 / 48 test cases passed.
public class Solution {
    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    int count;
    
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        // 9:24 - 9:43 - 10:23
        m = matrix.size();
        n = matrix.get(0).size();
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i < m; i++) res.add(new ArrayList());
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                List<Point> level1 = new ArrayList();
                level1.add(new Point(i, j));
                count = 0;
                bfs(matrix, level1, visited);
                res.get(i).add(count);
            }
        }
        
        return res;
    }
    
    public void bfs(List<List<Integer>> matrix, List<Point> level1, boolean[][] visited) {
        for(Point curr : level1) {
            int i = curr.x, j = curr.y;
            visited[i][j] = true;
            if(matrix.get(i).get(j) == 0) {
                return;
            }
        }
        List<Point> level2 = new ArrayList();
        count++;
        for(Point curr : level1) {
            int i = curr.x, j = curr.y;
            for(int[] dir : directions) {
                int x = i + dir[0], y = j + dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
                    continue;
                }
                level2.add(new Point(x, y));
            }
        }
        level1 = level2;
        bfs(matrix, level1, visited);
    }
}
