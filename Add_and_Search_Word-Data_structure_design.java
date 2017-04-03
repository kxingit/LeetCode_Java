/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
*/
public class WordDictionary {
    // 11:41 - 11:50 // bug, check if(null) create
    class Trie {
        boolean hasWord = false;
        Trie[] children = new Trie[26];
        
        void add(String s) {
            if(s.equals("")) {
                hasWord = true;
                return;
            }
            int c = s.charAt(0);
            if(children[c - 'a'] == null) { // if null !!
                children[c - 'a'] = new Trie();
            }
            children[c - 'a'].add(s.substring(1, s.length()));
        }
        
        boolean search(String s) {
            if(s.equals("")) {
                return this.hasWord;
            }
            
            char c = s.charAt(0);
            if(c != '.') {
                if(children[c - 'a'] == null) return false;
                return children[c - 'a'].search(s.substring(1, s.length()));
            }
            
            for(int i = 0; i < 26; i++) {
                if(children[i] == null) continue; // !!!
                if(children[i].search(s.substring(1, s.length()))) {
                    return true;
                }
            }
            
            return false;
        }
    }
 
    /** Initialize your data structure here. */
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}
