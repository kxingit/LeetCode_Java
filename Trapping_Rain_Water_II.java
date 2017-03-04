/*
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 */
public class Solution {
    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public class Cell {
        public int height, i, j;
        Cell(int h, int x, int y) {
            this.height = h;
            this.i = x;
            this.j = y;
        }
    }
    public class CellComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell x, Cell y)
        {
            return x.height - y.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        // 1:19 - 1:43 - 3:10
        // PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1, (Cell a, Cell b) -> 
        //     a.height - b.height
        // );
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1, new CellComparator());
        if(heightMap == null || heightMap.length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] isVisited = new boolean[m][n];
        
        // initialize
        for(int i = 0; i < m; i++) {
            pq.add(new Cell(heightMap[i][0], i, 0));
            pq.add(new Cell(heightMap[i][n - 1], i, n - 1));
            isVisited[i][0] = true;
            isVisited[i][n - 1] = true;
        }
        for(int j = 1; j <= n - 2; j++) {
            pq.add(new Cell(heightMap[0][j], 0, j));
            pq.add(new Cell(heightMap[m - 1][j], m - 1, j));
            isVisited[0][j] = true;
            isVisited[m - 1][j] = true;
        }
        
        // start from the smallest
        int res = 0;
        while(!pq.isEmpty()) {
            Cell curr = pq.poll();
            for(int[] dir : directions) {
                int x = curr.i + dir[0], y = curr.j + dir[1];
                if(x < 0 || x >= m || y < 0 || y >= n) continue;
                if(isVisited[x][y] == true) continue;
                isVisited[x][y] = true;
                int hxy = heightMap[x][y], hij = curr.height;
                if(hij > hxy) res += (hij - hxy);
                pq.add(new Cell(Math.max(hxy, hij), x, y));
            }
        }
        return res;
    }
}
