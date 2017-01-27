/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 */
public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
	// 3:18 - 3:34
	int m = triangle.size();
	int n = triangle.get(m - 1).size(); 
	int[][] dp = new int[m][n];
	if(m == 0 || n == 0) return 0;
	for(int i = m - 1; i >= 0; i--) {
	  for(int j = 0; j < triangle.get(i).size(); j++) {
		if(i == m - 1) {
		  dp[i][j] = triangle.get(i).get(j);
		} else {
		  dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
		}
	  }
	}
	return dp[0][0];
  }
}


// v2
// Rolling array
public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
	int m = triangle.size();
	int n = triangle.get(m - 1).size(); 
	int[][] dp = new int[2][n];
	if(m == 0 || n == 0) return 0;
	for(int i = m - 1; i >= 0; i--) {
	  for(int j = 0; j < triangle.get(i).size(); j++) {
		if(i == m - 1) {
		  dp[i % 2][j] = triangle.get(i).get(j);
		} else {
		  dp[i % 2][j] = triangle.get(i).get(j) + Math.min(dp[(i + 1) % 2][j], dp[(i + 1) % 2][j + 1]);
		}
	  }
	}
	return dp[0][0];
  }
}


// v3
public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
	// 9:55 - 10:02
	int m = triangle.size();
	if(m == 0) return 0;
	int n = triangle.get(m - 1).size();
	int[][] dp = new int[m][n];
	for(int i = m - 1; i >= 0; i--) {
	  for(int j = 0; j < triangle.get(i).size(); j++) {
		if(i == m - 1) {
		  dp[i][j] = triangle.get(i).get(j);
		} else {
		  dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
		}
	  }
	}
	return dp[0][0];
  }
}

// v4
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 8:37 - 8:41
        int m = triangle.size();
        if(m == 0) return 0; // how
        int n = triangle.get(m - 1).size();
        if(n == 0) return 0;
        int[][] dp = new int[2][n];
        for(int i = m - 1; i >=0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if(i == m - 1) {
                    dp[i % 2][j] = triangle.get(i).get(j);
                } else {
                    dp[i % 2][j] = triangle.get(i).get(j) + Math.min(dp[(i + 1) % 2][j], dp[(i + 1) % 2][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
