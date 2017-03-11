/*
 * Implement a trie with insert, search, and startsWith methods.
 */
class TrieNode {
    private TrieNode[] children;
    public boolean hasWord;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
    
    public void insert(String word, int index) {
        if (index == word.length()) {
            this.hasWord = true;
            return;
        }
        
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }
    
    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }
        
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}
 
 
public class Trie {
    private TrieNode root;
 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return node != null && node.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}
 
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// v2
// 1:11 - 11:30
class TrieNode { // spelling
    public TrieNode[] children;
    public boolean hasWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
    
    public void insert(String s, int i) {
        if(i == s.length()) { // save to the next level
            this.hasWord = true;
            return;
        }
        int pos = (int)(s.charAt(i) - 'a');
        if(this.children[pos] == null) {
            this.children[pos] = new TrieNode();
        }
        this.children[pos].insert(s, i + 1);
    }
    
    public TrieNode search(String s, int i) {
        if(i == s.length()) {
            return this;
        }
        int pos = (int)(s.charAt(i) - 'a');
        if(this.children[pos] == null) {
            return null;
        }
        return this.children[pos].search(s, i + 1); // [pos]
    }
}
 
public class Trie {
    
    TrieNode root;
 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root.search(word, 0);
        return node != null && node.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root.search(prefix, 0); // 0
        return node != null;
    }
}
 
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// v3
// 1:32 - 1:40
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
 
public class Trie {
    TrieNode root;
 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
     
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }
     
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root.search(word, 0);
        return node != null && node.hasWord;
    }
     
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root.search(prefix, 0);
        return node != null;
    }
}
 
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

// v4
    // 9:10
class TrieNode {
    TrieNode[] children;
    boolean hasWord;
    
    TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
    
    public void insert(String s, int i) {
        if(i == s.length()) {
            hasWord = true;
            return;
        }
        char c = s.charAt(i);
        if(children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
        }
        children[c - 'a'].insert(s, i + 1); // children!
    }
    
    public TrieNode search(String s, int i) {
        if(i == s.length()) {
            return this;
        }
        char c = s.charAt(i);
        if(children[c - 'a'] == null) {
            return null;
        }
        return children[c - 'a'].search(s, i + 1);
    }
}
public class Trie {
    TrieNode root;
 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root.search(word, 0);
        return node != null && node.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root.search(prefix, 0);
        return node != null;
    }
}
