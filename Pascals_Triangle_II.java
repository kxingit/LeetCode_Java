/*
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 11:25 - 11:27
        List<Integer> result = new ArrayList();
        int n = rowIndex + 1;
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == 0 || j == 0 || i == j) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            result.add(res[n - 1][i]);
        }
        return result;
    }
}

// v2: rolling array
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 11:30 - 11:32
        List<Integer> result = new ArrayList();
        int n = rowIndex + 1;
        int[][] res = new int[2][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == 0 || j == 0 || i == j) {
                    res[i % 2][j] = 1;
                } else {
                    res[i % 2][j] = res[(i - 1) % 2][j - 1] + res[(i - 1) % 2][j];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            result.add(res[(n - 1) % 2][i]);
        }
        return result;
    }
}

// v3 further improvement
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 11:30 - 11:38
        List<Integer> result = new ArrayList();
        int n = rowIndex + 1;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                if(i == 0 || j == 0 || i == j) {
                    res[j] = 1;
                } else {
                    res[j] = res[j - 1] + res[j];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            result.add(res[i]);
        }
        return result;
    }
}

// v4: Final
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 11:30 - 11:43
        List<Integer> result = new ArrayList();
        int n = rowIndex + 1;
        for(int i = 0; i < n; i++) result.add(0);
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                if(i == 0 || j == 0 || i == j) {
                    result.set(j, 1);
                } else {
                    result.set(j, result.get(j - 1) + result.get(j));
                }
            }
        }
        return result;
    }
}

// v5
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 11:44 - 11:47
        int n = rowIndex + 1;
        List<Integer> result = new ArrayList();
        for(int i = 0; i < n; i++) result.add(1); 
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 1; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}


// v6
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 1:02 - 1:05
        List<Integer> result = new ArrayList();
        for(int i = 0; i <= rowIndex; i++) result.add(1);
        
        for(int i = 2; i <= rowIndex; i++) {
            for(int j = i - 1; j > 0; j--) { // i -1!!!
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}

// v7
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 10:54 - 10:56
        List<Integer> res = new ArrayList();
        for(int i = 0; i <= rowIndex; i++) res.add(1);
        
        for(int i = 0; i <= rowIndex; i++) {
            for(int j = i - 1; j >= 1; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}
