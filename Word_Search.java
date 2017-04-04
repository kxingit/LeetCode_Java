/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/
public class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        // 4:30 - 4:39  wrong code
        if(board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int pos) {
        System.out.print(pos);
        if(pos == word.length()) return true;
        if(board[i][j] != word.charAt(pos)) return false;
        if(visited[i][j]) return false;
        visited[i][j] = true;
        
        for(int[] dir : directions) {
            int x = i + dir[0], y = i + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(dfs(board, x, y, visited, word, pos + 1)) {
                return true;
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
}

// v2 Corrected
public class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        // 4:30 - 4:39 - 5:20
        if(board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int pos) {
        if(pos == word.length()) return true;
        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        if(board[i][j] != word.charAt(pos)) return false;
        if(visited[i][j]) return false;
        
        visited[i][j] = true;
        
        // for(int[] dir : directions) {
        //     int x = i + dir[0], y = i + dir[1];
        //     if(dfs(board, x, y, visited, word, pos + 1)) {
        //         return true;
        //     }
        // }
        if(dfs(board, i + 1, j, visited, word, pos + 1)) return true;
        if(dfs(board, i, j + 1, visited, word, pos + 1)) return true;
        if(dfs(board, i - 1, j, visited, word, pos + 1)) return true;
        if(dfs(board, i, j - 1, visited, word, pos + 1)) return true;
        
        visited[i][j] = false;
        
        return false;
    }
}

// v3
public class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        // 4:30 - 4:39 - 5:20
        if(board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int pos) {
        if(pos == word.length()) return true;
        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        if(board[i][j] != word.charAt(pos)) return false;
        if(visited[i][j]) return false;
        
        visited[i][j] = true;
        
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1]; // typo 'j' not 'i'
            if(dfs(board, x, y, visited, word, pos + 1)) {
                return true;
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
}

// v4
public class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        // 4:30 - 4:39 bug: consider edge
        if(board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int pos) {
        if(pos == word.length()) return true;
        
        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        if(board[i][j] != word.charAt(pos)) return false;
        if(visited[i][j]) return false;
        
        visited[i][j] = true;

        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            // if(x < 0 || y < 0 || x >= m || y >= n) continue; // should not be here, always need a == length check
            if(dfs(board, x, y, visited, word, pos + 1)) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;
    }
}

// v5
public class Solution {
    int m, n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        // 5:54 - 5:58
        m = board.length;
        if(m == 0) return false;
        n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int pos) {
        if(pos == word.length()) return true;
        
        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        if(board[i][j] != word.charAt(pos)) return false;
        if(visited[i][j]) return false;
        
        visited[i][j] = true;
        
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if(dfs(board, x, y, visited, word, pos + 1)) {
                return true;
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
}
