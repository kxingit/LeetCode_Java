/*
Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
*/
public class Solution {
    int res = 0;
    int m, n;
    public int longestLine(int[][] M) {
        // 9:05 - 9:18
        m = M.length;
        if(m == 0) return 0;
        n = M[0].length;
        
        // horizontal
        int oldnum = 1, newnum = 2;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] != oldnum) continue;
                M[i][j] = newnum;
                int count = 1;
                int k = 1;
                while(j + k < n && M[i][j + k] == oldnum) {
                    count++;
                    M[i][j + k] = newnum;
                    k++;
                }
                res = Math.max(res, count);
            }
        }
        
        // virtical
        oldnum = 2;
        newnum = 3;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] != oldnum) continue;
                M[i][j] = newnum;
                int count = 1;
                int k = 1;
                while(i + k < m && M[i + k][j] == oldnum) {
                    count++;
                    M[i + k][j] = newnum;
                    k++;
                }
                res = Math.max(res, count);
            }
        }
        
        // diag
        oldnum = 3;
        newnum = 4;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] != oldnum) continue;
                M[i][j] = newnum;
                int count = 1;
                int k = 1;
                while(i + k < m && j + k < n && M[i + k][j + k] == oldnum) {
                    count++;
                    M[i + k][j + k] = newnum;
                    k++;
                }
                res = Math.max(res, count);
            }
        }
        
        // anti-diag
        oldnum = 4;
        newnum = 5;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] != oldnum) continue;
                M[i][j] = newnum;
                int count = 1;
                int k = 1;
                while(i + k < m && j - k >= 0 && M[i + k][j - k] == oldnum) {
                    count++;
                    M[i + k][j - k] = newnum;
                    k++;
                }
                res = Math.max(res, count);
            }
        }
        
        return res;
    }

}
