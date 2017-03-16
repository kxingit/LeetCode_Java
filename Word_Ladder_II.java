/*
   Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

   Only one letter can be changed at a time
   Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
   */
// TLE: 19 / 39 test cases passed.
public class Solution {
    Set<String> visited;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 10:28 - 10:46 - 11:03
        visited = new HashSet();
        
        List<String> solution = new ArrayList<String>();
        solution.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        
        dfs(beginWord, endWord, wordList, solution, res);
        
        return res;
    }
    
    public void dfs(String beginWord, String endWord, List<String> wordList, List<String> solution, List<List<String>> res) {
        if(beginWord.equals(endWord)) {
            if(solution.size() > 1) {
                if(res.size() == 0 || res.get(0).size() == solution.size()) {
                    res.add(new ArrayList(solution));
                }
                if(res.size() > 0 && res.get(0).size() > solution.size()) {
                    res.clear();
                    res.add(new ArrayList(solution));
                }
            }
            return;
        }
        if(res.size() > 0 && solution.size() > res.get(0).size()) {
            return;
        }
        
        for(int i = 0; i < wordList.size() ; i++) {
            String word = wordList.get(i);
            if(visited.contains(word) || !canTrans(word, beginWord)) {
                continue;
            }
            solution.add(word);
            visited.add(word);
            dfs(word, endWord, wordList, solution, res);
            solution.remove(solution.size() - 1);
            visited.remove(word);
        }
    }
    
    boolean canTrans(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1;
    }
}
