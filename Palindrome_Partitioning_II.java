/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

// Time Limit Exceeded: 28 / 29 test cases passed.
public class Solution {
    public int minCut(String s) {
        // 4:58 - 5:05
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if(isPal(sub)) {
                    if(j == 0) {
                        dp[i] = 0;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}

// Memorizing DFS Time Limite Exceeded, too many isPal() recursion when false
public class Solution {
    public int minCut(String s) {
        // Memorizing DFS
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        boolean[][] dppal = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(isPal(s, j, i, dppal)) {
                    if(j == 0) {
                        dp[i] = 0;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
    private boolean isPal(String s, int i, int j, boolean[][] dppal) {
        if(dppal[i][j]) return true;
        if(i == j || i + 1 == j) return s.charAt(i) == s.charAt(j);
        if(s.charAt(i) == s.charAt(j) && isPal(s, i + 1, j - 1, dppal)) return true;
        return false;
    }
}

// v3: Memorizing DFS
public class Solution {
    public int minCut(String s) {
        // Memorizing DFS
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        int[][] dppal = new int[n][n]; // 0 not calculated; 1 is pal; 2 not pal
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(isPal(s, j, i, dppal) == 1) {
                    if(j == 0) {
                        dp[i] = 0;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
    private int isPal(String s, int i, int j, int[][] dppal) {
        if(dppal[i][j] == 1 || dppal[i][j] == 2) return dppal[i][j];
        if(i == j || i + 1 == j) {
            if(s.charAt(i) == s.charAt(j)) {
                dppal[i][j] = 1;
            } else {
                dppal[i][j] = 2;
            }
            return dppal[i][j];
        }
        if(s.charAt(i) == s.charAt(j) && dppal[i + 1][j - 1] == 1) {
            dppal[i][j] = 1;
        } else {
            dppal[i][j] = 2;
        }
        return dppal[i][j];
    }
}

// v4
public class Solution {
    public int minCut(String s) {
        // pre-process substrings
        // 1:24 - 2:15
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        boolean[][] dppal = isPal(s); 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(dppal[j][i]) {
                    if(j == 0) {
                        dp[i] = 0;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
    private boolean[][] isPal(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j || i + 1 == j) {
                    res[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    if(s.charAt(i) != s.charAt(j)) {
                        res[i][j] = false;
                    } else {
                        res[i][j] = res[i + 1][j - 1];
                    }
                }
            }
        }
        return res;
    }
}

// v5
public class Solution {
    public int minCut(String s) {
        // 3:38 - 4:24
        int m = s.length();
        int[] dp = new int[m + 1];
        Arrays.fill(dp, m);
        boolean[][] isPal = isPal(s);
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= i; j++) {
                if(isPal[j - 1][i - 1]) {
                    if(j == 1) dp[i] = 0;
                    else dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[m];
    }
    boolean[][] isPal(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                if(i == j) {
                    res[i][j] = true;
                } else if(j + 1 == i) {
                    res[j][i] = s.charAt(i) == s.charAt(j);
                } else {
                    if(s.charAt(i) != s.charAt(j)) {
                        res[j][i] = false;
                    } else {
                        res[j][i] = res[j + 1][i - 1];
                    }
                }
            }
        }
        return res;
    }
}

// v6 
public class Solution {
    public int minCut(String s) {
        // 3:38 - 4:24
        int m = s.length();
        int[] dp = new int[m + 1];
        // Arrays.fill(dp, m);
        for(int i = 0; i <= m; i++) dp[i] = i - 1;
        boolean[][] isPal = isPal(s);
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= i; j++) {
                if(isPal[j - 1][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[m];
    }
    boolean[][] isPal(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                if(i == j) {
                    res[i][j] = true;
                } else if(j + 1 == i) {
                    res[j][i] = s.charAt(i) == s.charAt(j);
                } else {
                    if(s.charAt(i) != s.charAt(j)) {
                        res[j][i] = false;
                    } else {
                        res[j][i] = res[j + 1][i - 1];
                    }
                }
            }
        }
        return res;
    }
}
