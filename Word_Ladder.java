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

// v2: TLE: 19 / 39 test cases passed.
public class Solution {
    int res = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 3:38 - 3:45
        List<String> solution = new ArrayList();
        solution.add(beginWord);
        int n = wordList.size();
        boolean[] visited = new boolean[n];
        dfs(wordList, endWord, visited, solution);
        return res == Integer.MAX_VALUE ? 0 : res;
    }
     
    public void dfs(List<String> wordList, String target, boolean[] visited, List<String> solution) {
        if(solution.get(solution.size() - 1).equals(target)) {
            res = Math.min(res, solution.size());
            return;
        }
         
        String currWord = solution.get(solution.size() - 1);
        for(int i = 0; i < wordList.size(); i++) {
            String nextWord = wordList.get(i);
            if(visited[i]) continue;
            if(!canTrans(currWord, nextWord)) continue;
            visited[i] = true;
            solution.add(nextWord);
            dfs(wordList, target, visited, solution);
            visited[i] = false;
            solution.remove(solution.size() - 1);
        }
    }
     
    public boolean canTrans(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1;
    }
}

// v3: TLE: 21 / 39 test cases passed.
// DFS always TLE
public class Solution {
    int res = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 4:07
        Set<String> dict = new HashSet();
        for(String w : wordList) {
            dict.add(w);
        }
        List<String> solution = new ArrayList();
        solution.add(beginWord);
        dfs(dict, endWord, solution);
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    public void dfs(Set<String> dict, String target, List<String> solution) {
        if(solution.size() >= res) return;
        if(solution.get(solution.size() - 1).equals(target)) {
            res = Math.min(res, solution.size());
        }
        
        String currWord = solution.get(solution.size() - 1);
        for(int iw = 0; iw < currWord.length(); iw++) {
            for(int i = 0; i < 26; i++) {
                char c = (char)(i + 'a');
                if(c == currWord.charAt(iw)) continue;
                String nextWord = replace(currWord, iw, c);
                if(!dict.contains(nextWord)) continue;
                
                dict.remove(nextWord);
                solution.add(nextWord);
                dfs(dict, target, solution);
                dict.add(nextWord);
                solution.remove(nextWord);
            }
        }
    }
    
    public String replace(String s, int i, char c) {
        char[] tmp = s.toCharArray();
        tmp[i] = c;
        return new String(tmp);
    }
}

// v4
public class Solution {
    Set<String> dict = new HashSet();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 4:39 - 4:51
        for(String s : wordList) dict.add(s);
         
        int size = wordList.size();
        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        q.add(beginWord);
         
        int res = 1;
        while(q.size() > 0) {
            int n = q.size();
            res++;
            for(int i = 0; i < n; i++) {
                String currWord = q.poll();
                List<String> nextWords = genNext(currWord);
                for(String nextWord : nextWords) {
                    if(visited.contains(nextWord)) continue;
                     
                    visited.add(nextWord);
                    q.add(nextWord);
                    if(nextWord.equals(endWord)) return res;
                }
            }
        }
        return 0;
    }
     
    public List<String> genNext(String s) {
        List<String> list = new ArrayList();
        for(int i = 0; i < s.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == s.charAt(i)) continue;
                String next = replace(s, i, c);
                if(dict.contains(next)) {
                    list.add(next);
                }
 
            }
        }
        return list;
    }
     
    public String replace(String s, int i, char c) {
        char[] chars = s.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}

// v5
public class Solution {
    Set<String> dict = new HashSet();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 9:20 - 9:29 - 9:42
        for(String w : wordList) dict.add(w);
        
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        
        int res = 1;
        
        while(q.size() > 0) {
            int n = q.size();
            res++;
            for(int i = 0; i < n; i++) {
                String currw = q.poll();
                List<String> nexts = genNexts(currw);
                for(String next : nexts) {
                    q.add(next);
                    if(next.equals(endWord)) {
                        return res;
                    }
                }
            }
        }
        
        return 0;
    }
    
    public List<String> genNexts(String s) {
        List<String> res = new ArrayList();
        
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char originali = chars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == chars[i]) continue;
                chars[i] = c;
                String next = new String(chars);
                if(!dict.contains(next)) continue;
                dict.remove(next);
                res.add(next);
            }
            chars[i] = originali; // need to restore chars!!
        }
        return res;
    }
}

// v6
public class Solution {
    // 9:57 - 10:03
    HashSet<String> dict = new HashSet();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String w : wordList) dict.add(w);
        Queue<String> q = new LinkedList();
        q.add(beginWord);
         
        int len = 1;
        while(q.size() > 0) {
            int n = q.size();
            len++;
            for(int i = 0; i < n; i++) {
                String w = q.poll();
                List<String> nexts = getNexts(w);
                for(String next : nexts) {
                    if(next.equals(endWord)) {
                        return len;
                    }
                    q.add(next);
                }
            }
        }
        return 0;
    }
     
    public List<String> getNexts(String w) {
        List<String> res = new ArrayList();
        for(int i = 0; i < w.length(); i++) {
            char[] chars = w.toCharArray();
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == w.charAt(i)) continue;
                chars[i] = c;
                String next = new String(chars);
                if(!dict.contains(next)) continue;
                 
                dict.remove(next);
                res.add(new String(chars));
            }
        }
        return res;
    }
}
