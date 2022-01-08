/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    var stack = [];

    for (let i = 0; i < s.length; i++) {
        let ch = s.charAt(i);

        if (ch === '(' || ch === '[' || ch === '{') {
            stack.push(getEquivalentClosingBracket(ch));
        } else if (stack.length === 0 || stack.pop() !== ch) {
            return false;
        }
    }
    return stack.length === 0;
};

function getEquivalentClosingBracket(ch) {
    if (ch === '(') {
        return ')';
    }
    if (ch === '[') {
        return ']';
    }
    return '}';
};



 
