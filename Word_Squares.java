/*
 * Given a set of words (without duplicates), find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 */
// TLE: 13 / 16 test cases passed.
public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        // 3:25 - 3:46 - 4:36 // can have duplicates!
        List<List<String>> res = new ArrayList();
        int n = words.length;
        for(int i = 0; i < words.length; i++) {
            boolean[] visited = new boolean[n];
            List<String> solution = new ArrayList();
            // visited[i] = true;
            solution.add(words[i]);
            dfs(words, i, visited, solution, res);
        }
        
        return res;
    }
    
    public void dfs(String[] words, int pos, boolean[] visited, List<String> solution, List<List<String>> res) {
        if(solution.size() == words[0].length()) {
            if(isValid(solution)) {
                res.add(new ArrayList(solution));
            }
            return;
        }
        if(!isValid(solution)) return;
        
        for(int i = 0; i < words.length; i++) {
            // if(i == pos || visited[i]) continue;
            // visited[i] = true;
            solution.add(words[i]);
            dfs(words, i, visited, solution, res);
            // visited[i] = false;
            solution.remove(solution.size() - 1);
        }
    }
    
    public boolean isValid(List<String> solution) {
        int row = solution.size() - 1;
        
        for(int i = 0; i <= row; i++) {
            if(solution.get(i).charAt(row) != solution.get(row).charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

// v2
public class Solution {
     class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findByPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    return ans;

                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList<>();
        for (String w : words) {
            ansBuilder.add(w);
            search(len, trie, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }

        return ans;
    }

    private void search(int len, Trie tr, List<List<String>> ans,
            List<String> ansBuilder) {
        if (ansBuilder.size() == len) {
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }

        int idx = ansBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : ansBuilder)
            prefixBuilder.append(s.charAt(idx));
        List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
        for (String sw : startWith) {
            ansBuilder.add(sw);
            search(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }
}

// v3
public class Solution {
    
    class TrieNode {
        // TrieNode root = new TrieNode();
        TrieNode[] children = new TrieNode[26];
        boolean hasWord;
        
        public void insert(String s) {
            TrieNode node = this;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                if(i == s.length() - 1) {
                    node.hasWord = true;
                }
            }
        }
        
        public List<String> findPrefix(String s) {
            List<String> res = new ArrayList();
            StringBuffer solution = new StringBuffer(s);
            TrieNode node = this;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(node.children[c - 'a'] == null) {
                    return res;
                }
                node = node.children[c - 'a'];
            }
            dfs(node, solution, res);
            return res;
        }
        
        public void dfs(TrieNode node, StringBuffer solution, List<String> res) {
            if(node.hasWord == true) {
                res.add(solution.toString());
            }
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null) {
                    solution.append((char)(i +'a'));
                    dfs(node.children[i], solution, res);
                    solution.setLength(solution.length() - 1);
                }
            }
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        // 11:20 - 11:56 - 12:24
        
        TrieNode root = new TrieNode();
        for(String s : words) {
            root.insert(s);
        }
        
        List<List<String>> res = new ArrayList();
        List<String> solution = new ArrayList();
        for(String s : words) {
            solution.add(s);
            dfs(words, root, solution, res);
            solution.remove(solution.size() - 1);
        }
        return res;
    }
    
    public void dfs(String[] words, TrieNode root, List<String> solution, List<List<String>> result) {
        if(solution.size() == words[0].length()) {
            result.add(new ArrayList(solution));
            return;
        }
        
        StringBuffer prefix = new StringBuffer();
        for(int i = 0; i < solution.size(); i++) {
            int j = solution.size();
            prefix.append(solution.get(i).charAt(j));
        }
        
        List<String> nexts = root.findPrefix(prefix.toString());
        for(String next : nexts) {
            solution.add(next);
            dfs(words, root, solution, result);
            solution.remove(solution.size() - 1);
        }
    }
}
