/*

242. Valid Anagram
Easy

5929

232

Add to List

Share
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 
 
 */

class Solution {
    public boolean isAnagram(String s, String t) {
     HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++)
        {
            char ch1=s.charAt(i);
            if(!map1.containsKey(ch1))
                map1.put(ch1,1);
            else
                map1.put(ch1,map1.get(ch1)+1);   
             
        }
        for(int i=0;i<t.length();i++)
        {
            char ch2=t.charAt(i);
            if(map1.containsKey(ch2))
            {
                 int val=map1.get(ch2);
                 map1.put(ch2,val-1);
            }
            else
                return false;
             
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(map1.get(ch)!=0)
                return false;
        }
        return true;
    }
}
