/*
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 *  0 - A gate.
 *  INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *  Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 */
public class Solution {
    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        // 4:12 - 4:25
        Queue<Point> q = new LinkedList();
        if(rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new Point(i, j));
                }
            }
        }
        
        while(q.size() > 0) {
            int qsize = q.size();
            for(int k = 0; k < qsize; k++) {
                Point curpoint = q.poll();
                int i = curpoint.x, j = curpoint.y;
                for(int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n) continue;
                    if(rooms[x][y] == 2147483647) {
                        rooms[x][y] = rooms[i][j] + 1;
                        q.add(new Point(x, y));
                    }
                }
            }
        }
        
        return;
    }
}


// v2
public class Solution {
    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        // 4:12 - 4:25
        Queue<Point> q = new LinkedList();
        if(rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new Point(i, j));
                }
            }
        }
        
        while(q.size() > 0) {
            // int qsize = q.size();
            // for(int k = 0; k < qsize; k++) {
                Point curpoint = q.poll();
                int i = curpoint.x, j = curpoint.y;
                for(int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n) continue;
                    if(rooms[x][y] == 2147483647) {
                        rooms[x][y] = rooms[i][j] + 1;
                        q.add(new Point(x, y));
                    }
                }
            // }
        }
        
        return;
    }
}
