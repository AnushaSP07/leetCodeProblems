/*

387. First Unique Character in a String
Easy

5874

215

Add to List

Share
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1

*/

class Solution {
    public int firstUniqChar(String s) {
         for(int i = 0, j = 1; i < s.length(); i++, j++){
            String firstPart = s.substring(0, i);
            String secondPart = s.substring(j, s.length());

  if(secondPart.indexOf(s.charAt(i)) == -1 && firstPart.indexOf(s.charAt(i)) ==-1){
                return i;
            }
        }
        return -1;
    }
}
