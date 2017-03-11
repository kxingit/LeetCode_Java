/*
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 */
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
 
    public boolean search(String s, int i) {
        if(i == s.length()) {
            return this.hasWord;
        }
         
        if(s.charAt(i) == '.') {
            for(int pos = 0; pos < 26; pos++) {
                if(children[pos] != null && children[pos].search(s, i + 1)) {
                    return true;
                }
            }
            return false;
        }
         
        int pos = s.charAt(i) - 'a';
        if(children[pos] == null) {
            return false;
        }
        return children[pos].search(s, i + 1);
    }
 
}
 
 
public class WordDictionary {
 
    //1:57 - 2:06  modified trie tree
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
     
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.insert(word, 0);
    }
     
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.search(word, 0);
    }
}



// v2
public class WordDictionary {
    // 9:40 -10:06
    class TrieNode {
        TrieNode children[];
        boolean hasWord;
         
        TrieNode() {
            children = new TrieNode[26];
            hasWord = false;
        }
    }
 
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
     
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int i = 0;
        TrieNode node = root;
        while(i < word.length()) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            i++;
        }
        node.hasWord = true;
    }
     
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchhelper(word, 0, root);
    }
     
    public boolean searchhelper(String word, int index, TrieNode node) {
        if(word.length() == index) return node.hasWord;
        char c = word.charAt(index);
         
        if(c != '.') {
            if(node.children[c - 'a'] == null) return false;
            return searchhelper(word, index + 1, node.children[c - 'a']);
        }  
        // is '.'
        for(int ic = 0; ic < 26; ic++) {
            if(node.children[ic] == null) continue; // !
            if(searchhelper(word, index + 1, node.children[ic])) {
                return true;
            }
        }
        return false;
    }
}


