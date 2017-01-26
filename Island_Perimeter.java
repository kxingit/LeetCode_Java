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
