/* 
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0]; // assume that the first string is the answer
        
        for(int i = 1; i < strs.length; i++) // loop through all of the remaing strings
        {
            while(strs[i].indexOf(prefix) != 0) // if equals 0 means prefix exists
            {
                prefix = prefix.substring(0, prefix.length() - 1); // remove  the last letter
            }
        }
        return prefix;
    }
}
