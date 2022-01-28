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

const DOT = '.'
const endHere = 'endHere'

class WordDictionary {
    constructor () {
        this.root = {}
    }
    
    addWord (word) {
        const addChar = (index, pointer) => {
            const char = word.charAt(index)
            
            if (!char) return false
            
            pointer[char] = pointer[char] || {endHere: false}
            
            addChar(index + 1, pointer[char])
            
            if (index === word.length - 1) pointer[endHere] = true
            
            return true
        }
        
        return addChar(0, this.root)
    }
    
    search (word) {
        let hasFound = false
        
        const confirmHasFound = (index, pointer) => {
            if (index === word.length - 1 && pointer[endHere]) hasFound = true
        }
        
        
        const findChar = (index, pointer)  => {
            const char = word.charAt(index)
            
            if (!char || hasFound) return false
            
            if (!(char in pointer)) {
                if (char !== DOT)  return false
                
                const keys = Object.keys(pointer)
                
                for (let i = 0; i < keys.length; i++){
                    if (hasFound) break
                    
                    const key = keys[i]
                    
                    if (key === endHere) continue
                    
                    findChar(index + 1, pointer[key])
                }
                
                confirmHasFound(index, pointer)
                
                return false
            }
            
            findChar(index + 1, pointer[char])
            
            confirmHasFound(index, pointer)
            
        }
        
        findChar(0, this.root)
        
        return hasFound
        
    }
}
