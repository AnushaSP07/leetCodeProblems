/*

383. Ransom Note
Easy

2645

352

Add to List

Share
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

*/


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char letter : magazine.toCharArray()) {
            magazineMap.put(letter, magazineMap.getOrDefault(letter, 0) + 1);
        }

        for (char letter : ransomNote.toCharArray()) {
            ransomNoteMap.put(letter, ransomNoteMap.getOrDefault(letter, 0) + 1);
            if (ransomNoteMap.get(letter) > magazineMap.getOrDefault(letter, 0))
                return false;
        }

        return true;
    }
}
