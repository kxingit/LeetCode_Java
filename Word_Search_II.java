/*
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
// 2:23 - 2:37 - 3:20
class TrieNode {
    public TrieNode[] children;
    boolean hasWord;
 
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
 
    public void insert(String s, int i) {
        if(i == s.length()) {
            hasWord = true;
            return;
        }
        int pos = s.charAt(i) - 'a';
        if(children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(s, i + 1);
    }
 
    public TrieNode search(String s, int i) {
        if(i == s.length()) {
            return this;
        }
        int pos = s.charAt(i) - 'a';
        if(children[pos] == null) {
            return null;
        }
        return children[pos].search(s, i + 1);
    }
 
}
 
public class Solution {
    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            root.insert(w, 0);
        }
        
        HashSet<String> res = new HashSet();
        if(board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<String>(res);
        }
        int m = board.length, n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                StringBuffer solution = new StringBuffer(); // initialize in every ij loop
                boolean[][] isVisited = new boolean[m][n];
                isVisited[i][j] = true;
                solution.append(board[i][j]);
                dfs(board, root, i, j, solution, res, isVisited);
            }
        }
        return new ArrayList<String>(res);
    }
    
    public void dfs(char[][] board, TrieNode root, int i, int j, StringBuffer solution, HashSet res, boolean[][] isVisited) {
        TrieNode node = root.search(solution.toString(), 0);
        if(node == null) return;
        if(node.hasWord) res.add(solution.toString());
        
        int m = board.length, n = board[0].length;
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n || isVisited[x][y]) continue;
            isVisited[x][y] = true;
            solution.append(board[x][y]);
            dfs(board, root, x, y, solution, res, isVisited);
            solution.deleteCharAt(solution.length() - 1);
            isVisited[x][y] = false; // resume state!
        }
    }
}
