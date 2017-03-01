/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class Solution {
  public int numIslands(char[][] grid) {
	// 4:00 - 4:13
	int result = 0;
	int m = grid.length;
	if(m == 0) return 0;
	int n = grid[0].length;
	if(m == 0 || n == 0) return 0;
	for(int i = 0; i < m; i++) {
	  for(int j = 0; j < n; j++) {
		if(grid[i][j] == '1') {
		  result++;
		  markIsland(grid, i, j);
		}
	  }
	}
	return result;
  }
  private void markIsland(char[][] grid, int i, int j) {
	int m = grid.length;
	int n = grid[0].length;
	if(i < 0 || j < 0 || i >= m || j >= n) return;
	if(grid[i][j] == '1') {
	  grid[i][j] = '*';
	}  
	if(i - 1 >= 0 && grid[i - 1][j] == '1') {
	  markIsland(grid, i - 1, j);
	}
	if(i + 1 < m && grid[i + 1][j] == '1') {
	  markIsland(grid, i + 1, j);
	}
	if(j - 1 >= 0 && grid[i][j - 1] == '1') {
	  markIsland(grid, i, j - 1);
	}
	if(j + 1 < n && grid[i][j + 1] == '1') {
	  markIsland(grid, i, j + 1);
	}
  }
}

// v2
public class Solution {
  public int numIslands(char[][] grid) {
	// 4:00 - 4:13
	int result = 0;
	int m = grid.length;
	if(m == 0) return 0;
	int n = grid[0].length;
	for(int i = 0; i < m; i++) {
	  for(int j = 0; j < n; j++) {
		if(grid[i][j] == '1') {
		  result++;
		  markIsland(grid, i, j);
		}
	  }
	}
	return result;
  }
  private void markIsland(char[][] grid, int i, int j) {
	int m = grid.length;
	int n = grid[0].length;
	if(i < 0 || j < 0 || i >= m || j >= n) return;
	if(grid[i][j] != '1') return;
	grid[i][j] = '*';
	markIsland(grid, i - 1, j);
	markIsland(grid, i + 1, j);
	markIsland(grid, i, j - 1);
	markIsland(grid, i, j + 1);
  }
}


// v3
public class Solution {
  public int numIslands(char[][] grid) {
	// 11:16 - 11:23
	if(grid == null) return 0;
	int m = grid.length;
	if(m == 0) return 0;
	int n = grid[0].length;
	if(n == 0) return 0;
	int result = 0;
	for(int i = 0; i < m; i++) {
	  for(int j = 0; j < n; j++) {
		if(grid[i][j] == '1') {
		  markIsland(grid, i, j);
		  result++;
		}
	  }
	}
	return result;
  }
  private void markIsland(char[][] grid, int i, int j) {
	int m = grid.length;
	int n = grid[0].length;
	if(i < 0 || j < 0 || i >= m || j >= n) {
	  return;
	}
	if(grid[i][j] != '1') {
	  return;
	}
	grid[i][j] = '*';
	markIsland(grid, i - 1, j);
	markIsland(grid, i, j - 1);
	markIsland(grid, i + 1, j);
	markIsland(grid, i, j + 1);
  }
}


// v4
public class Solution {
    public int numIslands(char[][] grid) {
        // 8:44 - 8:50
        int result = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        } else {
            grid[i][j] = '3';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}


// v5
public class Solution {
    private int m, n;
    public int numIslands(char[][] grid) {
        // 3:44 - 3:56
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != '1') continue;
                markIsland(grid, i, j);
                result++;
            }
        }
        return result;
    }
    private void markIsland(char[][] grid, int i, int j) {
        if(i == -1 || j == -1 || i == m || j == n) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '3';
        markIsland(grid, i - 1, j);
        markIsland(grid, i + 1, j);
        markIsland(grid, i, j - 1);
        markIsland(grid, i, j + 1);
    }
}

// v6 
public class Solution {
    // 1:15 - 1:21
    int m, n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length; n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res; 
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == m || j == n) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            dfs(grid, x, y);
        }
    }
}
