/*

120. Triangle
Medium

5915

407

Add to List

Share
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 
 
 */

class Solution {
   private Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return dfs(0, 0, triangle);
    }

    private int dfs(int level, int i, List<List<Integer>> triangle) {
        if (memo[level][i] != null) return memo[level][i];

        int path = triangle.get(level).get(i);
        if (level < triangle.size() - 1) 
            path += Math.min(dfs(level + 1, i, triangle), dfs(level + 1, i + 1, triangle));

        return memo[level][i] = path;
    }
}
