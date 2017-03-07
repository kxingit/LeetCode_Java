/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 */
public class Solution {
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
 
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 10:47 - 11:47
        if(beginWord.equals(endWord)) return 1;
        HashSet<String> dict = new HashSet();
        for(String word : wordList) dict.add(word);
        
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        HashSet<String> visited = new HashSet();
        visited.add(beginWord);
        
        int res = 0;
        while(q.size() > 0) {
            int n = q.size();
            res++;
            for(int i = 0; i < n; i++) {
                String curr = q.poll();
                List<String> nextlist = getNextWords(curr, dict);
                for(String nextword : nextlist) {
                    if(visited.contains(nextword)) continue;
                    visited.add(nextword);
                    q.add(nextword);
                    if(nextword.equals(endWord)) {
                        return res + 1;
                    }
                }
            }
        }
        return 0;
    }
}
