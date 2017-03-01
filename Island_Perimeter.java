/*
 * Island Perimeter
 */
public class Solution {
  public int islandPerimeter(int[][] grid) {
	// 4:47 - 4:52
	int result = 0;
	int m = grid.length;
	if(m == 0) return 0;
	int n = grid[0].length;
	for(int i = 0; i < m; i++) {
	  for(int j = 0; j < n; j++) {
		if(grid[i][j] == 0) continue;
		if(i == 0 || grid[i - 1][j] == 0) result++;
		if(i == m - 1 || grid[i + 1][j] == 0) result++;
		if(j == 0 || grid[i][j - 1] == 0) result++;
		if(j == n - 1 || grid[i][j + 1] == 0) result++;
	  }
	}
	return result;
  }
}


// v2
public class Solution {
  public int islandPerimeter(int[][] grid) {
	// 11:25 - 11:34
	if(grid == null) return 0;
	int m = grid.length;
	if(m == 0) return 0;
	int n = grid[0].length;
	if(n == 0) return 0;
	int result = 0;
	for(int i = 0; i < m; i++) {
	  for(int j = 0; j < n; j++) {
		if(grid[i][j] == 0) continue; // !!
		if(i == 0 || grid[i - 1][j] == 0) result++;
		if(i == m - 1 || grid[i + 1][j] == 0) result++;
		if(j == 0 || grid[i][j - 1] == 0) result++;
		if(j == n - 1 || grid[i][j + 1] == 0) result++;
	  }
	}
	return result;
  }
}

// v3 
public class Solution {
    public int islandPerimeter(int[][] grid) {
		// 8:53 - 8:56
		int m = grid.length;
		if(m == 0) return 0;
		int n = grid[0].length;
		if(n == 0) return 0;
		int result = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 0) continue;
				if(i == 0 || grid[i - 1][j] == 0) result++;
				if(j == 0 || grid[i][j - 1] == 0) result++;
				if(i == m - 1 || grid[i + 1][j] == 0) result++;
				if(j == n - 1 || grid[i][j + 1] == 0) result++;
			}
		}
		return result;
    }
}

// v4
public class Solution {
    public int islandPerimeter(int[][] grid) {
        // 4:03 - 4:10
        int result = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue; // !!
                if(i == 0 || grid[i - 1][j] == 0) result++;
                if(j == 0 || grid[i][j - 1] == 0) result++;
                if(i == m - 1 || grid[i + 1][j] == 0) result++;
                if(j == n - 1 || grid[i][j + 1] == 0) result++;
            }
        }
        return result;
    }
}

// v5
public class Solution {
    public int islandPerimeter(int[][] grid) {
        // 1:27 - 1:30
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                if(i == 0 || grid[i - 1][j] == 0) res++;
                if(j == 0 || grid[i][j - 1] == 0) res++;
                if(i == m - 1 || grid[i + 1][j] == 0) res++;
                if(j == n - 1 || grid[i][j + 1] == 0) res++;
            }
        }
        return res;
    }
}

// v6
public class Solution {
    public int islandPerimeter(int[][] grid) {
        // 1:27 - 1:30 - 1:36
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                for(int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];
                    if(x < 0 || y < 0 || x > m - 1 || y > n - 1 || grid[x][y] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
