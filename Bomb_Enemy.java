/*
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 */
public class Solution {
    int m, n;
    public int maxKilledEnemies(char[][] grid) {
        // 10:18 - 10:24
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0')
                    res = Math.max(res, maxKill(grid, i, j));
            }
        }
        return res;
    }
    
    public int maxKill(char[][] grid, int istart, int jstart) {
        int count = 0;
        for(int i = istart + 1; i < m; i++) {
            if(grid[i][jstart] == 'E') {
                count++;
            } else if(grid[i][jstart] == 'W') {
                break;
            }
        }
        
        for(int i = istart - 1; i >= 0; i--) {
            if(grid[i][jstart] == 'E') {
                count++;
            } else if(grid[i][jstart] == 'W') {
                break;
            }
        }
        
        for(int j = jstart + 1; j < n; j++) {
            if(grid[istart][j] == 'E') {
                count++;
            } else if(grid[istart][j] == 'W') {
                break;
            }
        }
        
        for(int j = jstart - 1; j >= 0; j--) {
            if(grid[istart][j] == 'E') {
                count++;
            } else if(grid[istart][j] == 'W') {
                break;
            }
        }
        
        return count;
    }
}
