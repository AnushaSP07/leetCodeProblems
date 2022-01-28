/*

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

*/

class WordDictionary {

    TrieNode root;
    
    class TrieNode {
        boolean isLast;
        TrieNode[] children;
        
        public TrieNode() {
            this.isLast = false;
            this.children = new TrieNode[26];
        }
    }

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = this.root;
        
        for(char c : word.toCharArray()) {
            if(current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        
        current.isLast = true;
    }
    
    public boolean search(String word) {
        return search(this.root, word, 0);
    }
    
    private boolean search(TrieNode node, String word, int index) {
        // if node is null there is no path so return false
        if(node == null) return false;
        
        // if reached end of word check if node currently on is an end node
        if(index == word.length()) return node.isLast;
        
        if(word.charAt(index) == '.') {
            boolean exists = false;
            
            for(int i = 0; i < 26; i++) {
                exists = exists || search(node.children[i], word, index + 1);
                if(exists) return true;
            }
            
            return false;
        } else {
            if(node.children[word.charAt(index) - 'a'] == null) return false;
            
            return search(node.children[word.charAt(index) - 'a'], word, index + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
