/*
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 */
public class Solution {
    public char[][] originalBoard;
    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        // 10:30 - 10:45 - 11:14
        originalBoard = board.clone();
        int i = click[0], j = click[1];
        char curr = check(i, j);
        if(curr == 'E') {
            dfs_blank(board, i, j);
        } else if (curr == 'M') {
            board[i][j] = 'X';
        } else {
            board[i][j] = curr;
        }
        return board;
    }
    private char check(int i, int j) {
        int m = originalBoard.length, n = originalBoard[0].length;
        if(originalBoard[i][j] == 'M') {
            return 'M';
        } else if (originalBoard[i][j] == 'E') {
            int nMine = 0;
            for(int[] dir : directions) {
                int x = i + dir[0], y = j + dir[1];
                if(x < 0 || y < 0 || x > m - 1 || y > n - 1) continue;
                if(originalBoard[x][y] == 'M') nMine++;
            }
            return nMine == 0 ? 'E' : (char)('0' + nMine);
        } else {
            return originalBoard[i][j];
        }
    }
    private void dfs_blank(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return;
        if(check(i, j) == 'E') {
            board[i][j] = 'B';
            for(int[] dir : directions) {
                int x = i + dir[0], y = j + dir[1];
                dfs_blank(board, x, y);
            }
        } else {
            board[i][j] = check(i, j);
        }
    }
}
