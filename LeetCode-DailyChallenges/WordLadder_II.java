/*

126. Word Ladder II
Hard

4142

455

Add to List

Share
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
 
 */

class Solution {
   Map<String, List<List<String>>> buf;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!remove(wordList, endWord)) return new ArrayList<>();
        remove(wordList, beginWord);
        wordList.add(endWord);
        buf = new HashMap<>();
        Map<String, List<String>> graph = buildLadderGraph(beginWord, endWord, wordList);
        traverseLadderGraph(graph, beginWord, endWord);
        return buf.getOrDefault(beginWord, new ArrayList<>());
    }

    private List<List<String>> traverseLadderGraph(Map<String, List<String>> graph, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            buf.put(beginWord, new ArrayList<>());
            buf.get(beginWord).add(new ArrayList<>(Arrays.asList(endWord)));
            return buf.get(beginWord);
        }
        if (buf.containsKey(beginWord)) return buf.get(beginWord);
        if (!graph.containsKey(beginWord)) return new ArrayList<>();
        List<List<String>> next = new ArrayList<>();
        for (String s : graph.get(beginWord)) {
            next.addAll(traverseLadderGraph(graph, s, endWord));
        }
        buf.put(beginWord, new ArrayList<>());
        for (List<String> route : next) {
            List<String> l = new ArrayList<>(route);
            l.add(0, beginWord);
            buf.get(beginWord).add(l);
        }
        return buf.get(beginWord);
    }

    private Map<String, List<String>> buildLadderGraph(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> needDelete = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        boolean flag = false;
        int size = q.size();
        while (!q.isEmpty()) {
            String s = q.poll();
            map.put(s, new ArrayList<>());
            for (String word : wordList) {
                if (isLadder(word, s)) {
                    if (!needDelete.contains(word)) q.offer(word);
                    needDelete.add(word);
                    map.get(s).add(word);
                    if (word.equals(endWord)) flag = true;
                }
            }
            if (--size == 0) {
                if (flag) break;
                int len = wordList.size();
                for (int i = 0; i < len; i++) if (!needDelete.contains(wordList.get(i))) wordList.add(wordList.get(i));
                wordList = wordList.subList(len, wordList.size());
                needDelete = new HashSet<>();
                size = q.size();
            }
        }
        return map;
    }

    private boolean remove(List<String> wordList, String endWord) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                Collections.swap(wordList, i, wordList.size() - 1);
                wordList.remove(wordList.size() - 1);
                return true;
            }
        }
        return false;
    }

    private boolean isLadder(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) diff++;
        return diff == 1;
    }
}
