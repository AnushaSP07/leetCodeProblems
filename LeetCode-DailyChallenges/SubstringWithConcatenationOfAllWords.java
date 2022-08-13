/*

30. Substring with Concatenation of All Words
Hard

2841

2117

Add to List

Share
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        Arrays.stream(words).forEach(word -> wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1));

        int wordLength = words[0].length(), count = words.length;
        for (int index = 0; index <= s.length() - wordLength * count; ++index) {
            if (isContainsAllWords(wordsMap, s.substring(index, index + wordLength * count), wordLength))
                indices.add(index);
        }

        return indices;
    }

    private boolean isContainsAllWords(Map<String, Integer> wordsMap, String substring, int wordLength) {
        Map<String, Integer> substringWordsMap = new HashMap<>();
        for (int i = 0; i < substring.length(); i += wordLength) {
            String word = substring.substring(i, i + wordLength);
            substringWordsMap.put(word, substringWordsMap.getOrDefault(word, 0) + 1);
            
			if (substringWordsMap.get(word) > wordsMap.getOrDefault(word, 0))
                return false;
        }
        return substringWordsMap.equals(wordsMap);
    }
}
