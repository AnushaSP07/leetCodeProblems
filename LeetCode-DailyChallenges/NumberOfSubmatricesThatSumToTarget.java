/*

1074. Number of Submatrices That Sum to Target
Hard

2404

55

Add to List

Share
Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

 

Example 1:


Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.
Example 2:

Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
Example 3:

Input: matrix = [[904]], target = 0
Output: 0
 
 
 */

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        //int[][] sum = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 1; j < col; j++){
                //sum[i][j] =sum[i][j-1] + matrix[i][j-1];
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        for(int start = 0; start < col; start++){
            for(int end = start; end < col; end++){
                int subMatrixSum = 0;
                
                Map<Integer, Integer> countElm = new HashMap<Integer, Integer>();
                countElm.put(0,1);
                
                for(int k = 0; k < row; k++){
                    //subMatrixSum += sum[k][end] - sum[k][start];
                    int prefixSum = start == 0 ? 0:matrix[k][start-1];
                    subMatrixSum += matrix[k][end] - prefixSum;
                    
                    if(countElm.containsKey(subMatrixSum - target))
                        res += countElm.get(subMatrixSum - target);
                    
                    int r = countElm.getOrDefault(subMatrixSum, 0);
                    countElm.put(subMatrixSum, r+1);
                }
            }
        }
        
        return res;
    }
}
