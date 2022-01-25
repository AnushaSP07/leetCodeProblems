/*

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104

*/

class Solution {
    public boolean validMountainArray(int[] arr) {
        
        boolean isAsc = false, isDesc = false;
        int n = arr.length;
        
        for(int i=0;i<n-1;i++) {
            if(arr[i+1] > arr[i] && !isDesc) { // strictly increasing & no descending found
                isAsc = true;
            } else if(arr[i+1] < arr[i] && isAsc) { // strictly decreasing & ascending completed
                isDesc = true;
            } else {
                return false; // every other possibility
            }
        }
        
        return isAsc && isDesc; // and of strictly increasing & decreasing
        
    }
}
