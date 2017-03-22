/*
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 *
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */
public class TicTacToe {
    // 12:37 - 12:46
    int n;
    int[] row_count, col_count;
    int diag, anti_diag;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        row_count = new int[n];
        col_count = new int[n];
        diag = 0;
        anti_diag = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int increament = player == 1 ? 1 : -1;
        row_count[row] += increament;
        col_count[col] += increament;
        if(row == col) diag += increament;
        if(row + col == n - 1) anti_diag += increament;
        if(row_count[row] == n || col_count[col] == n || diag == n || anti_diag == n) {
            return 1;
        } else if (row_count[row] == -n || col_count[col] == -n || diag == -n || anti_diag == -n) {
            return 2;
        } else {
            return 0;
        }
    }
}
