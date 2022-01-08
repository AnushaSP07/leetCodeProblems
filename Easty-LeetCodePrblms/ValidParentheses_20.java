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

class Solution {
    public boolean isValid(String s) {
       Stack<Character> s1 = new Stack<Character>();// STACK is created
        for(int i = 0;i<s.length();i++){
            if ((s.charAt(i)=='(') || (s.charAt(i)=='{') || (s.charAt(i)=='[')){
                //if opening is occurred add in stack
                s1.push(s.charAt(i));
            } else { 
                // closing is occured 
                 if(s1.isEmpty()){ 
        // condition for closing occuring at very first place
          return false;
            }
          char top = s1.pop(); 
        // suppose if presnt = '[' and top of stack is = ']' so matched
         if((s.charAt(i)==']' && top=='[') || s.charAt(i)=='}' && top=='{'|| s.charAt(i)==')' && top=='(' ){
             continue;
            }
          else {    
        // not matched 
         return false;
          }
      }
  }

  return s1.isEmpty(); // if after iteration STACK is empty means all openings has closings and is VALID 
    }
}
