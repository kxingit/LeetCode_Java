/*
 * Total Accepted: 41428
 * Total Submissions: 113638
 * Difficulty: Medium
 * Contributors: Admin
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 */
public class Solution {
    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
     
    public void gameOfLife(int[][] board) {
        // 10:35 - 10:50
        int m = board.length, n = board[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            res[i] = board[i].clone();
        }
         
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int nn = nNeighbors(board, i ,j);
                if(board[i][j] == 1) {
                    if(nn < 2 || nn > 3) {
                        res[i][j] = 0;
                    }
                } else {
                    if(nn == 3) {
                        res[i][j] = 1;
                    }
                }
            }
        }
 
        for(int i = 0; i < m; i++) {
            board[i] = res[i].clone();
        }
    }
     
    private int nNeighbors(int[][] A, int i, int j) {
        int m = A.length, n = A[0].length;
        int res = 0;
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(A[x][y] == 1) { // typo
                res++;
            }
        }
        return res;
    }
}


// v2: In-place. 
public class Solution {
    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    
    public void gameOfLife(int[][] board) {
        // 10:50 - 11:01
        // in-place: 0: 0->0, 1: 1->0, 2: 0->1, 3: 1->1
        // Original states -- [][] % 2
        // New states -- [][] / 2
        int m = board.length, n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int nn = nNeighbors(board, i ,j);
                if(board[i][j] == 1) {
                    if(nn < 2 || nn > 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 3;
                    }
                } else {
                    if(nn == 3) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = board[i][j] / 2;
            }
        }
        
    }
    
    private int nNeighbors(int[][] A, int i, int j) {
        int m = A.length, n = A[0].length;
        int res = 0;
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(A[x][y] % 2 == 1) {
                res++;
            }
        }
        return res;
    }
}
